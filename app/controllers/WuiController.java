package controllers;

import java.util.Map;
import de.htwg.battleship.controller.IMasterController;
import de.htwg.battleship.observer.IObserver;
import de.htwg.battleship.util.State;
import models.User;
import models.GameInstance;
import models.messages.*;
import models.Converter;
import play.mvc.WebSocket;
import akka.actor.*;

public class WuiController implements IObserver {
    
    private static final String HORIZONTAL_ORIENTATION = "true";
    private static final String PLAYERNAME_PREFIX = "PLAYERNAME ";
    
    private GameInstance gameInstance;
    private IMasterController master;
    private ActorRef socket;
    private boolean isPlayerOne;
    
    public WuiController(IMasterController master, ActorRef socket, boolean isPlayerOne) {
        this.master = master;
        this.socket = socket;
        this.isPlayerOne = isPlayerOne;
        master.addObserver(this);
        send(new ChatMessage("Welcome to the Game!", "Battlefield"));
    }
    
    public void setGameInstance(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
    }
    
    public void chat(ChatMessage message) {
        this.send(message);
    }
    
    private void send(Message msg) {
        //System.out.println("[Send Message from: " + this + " to socket: " + socket + "]");
        if (msg != null && socket != null) {
            socket.tell(msg.toJSON(), socket);
        }
    }
    
    public void startGame() {
        this.master.startGame();
    }
    
     public void handleMessage(String message) {
        System.out.println("Incoming message from Client: " + message + "   WUI: " + this);
        
        if(message.equals("RESTART")) {
            master.restartGame();
            return;
        }
        
        if (message.startsWith(GameInstance.CHAT_PREFIX)) {
            this.gameInstance.chat(message, isPlayerOne);
            return;
        }
        
        if(message.startsWith(PLAYERNAME_PREFIX)) {
            String[] name = message.split(" ");
            master.setPlayerName(name[1]);
            return;
        }
        
        String[] field = message.split(" ");
        if (field.length == 3) {
            // x y orientation -> which player
            placeShip(field);
        } else if (field.length == 2) {
            // x y -> test which player
            shoot(field);
        } else {
            send(new InvalidMessage());
        }
    }
    
   
    
      @Override
    public void update() {
       if(isPlayerOne) {
           System.out.println("[GameUpdate] - " + isPlayerOne + " - Player1: " + master.getPlayer1().getName() + " -- State:  " + master.getCurrentState());
           updatePlayerOne();
       } else {
           System.out.println("[GameUpdate] - " + isPlayerOne + " - Player2: " + master.getPlayer2().getName() + " -- State:  " + master.getCurrentState());
           updatePlayerTwo();
       }
    }
    
    private void updatePlayerOne() {
        Message msg = null;
        State currentState = master.getCurrentState();
        switch(currentState) {
            case GETNAME1: msg = new GetNameMessage(); break;
            case GETNAME2: msg = new WaitMessage(); break;
            case PLACE1:
            case FINALPLACE1:
                msg = new ShipMessage(currentState, Converter.createShipMap(master.getPlayer1().getOwnBoard())); 
                break;
            case PLACE2:
            case FINALPLACE2:
                msg = new WaitMessage();
                break;
            case SHOOT1:
                msg = new ShootMessage(currentState, 
                                        Converter.createShootMap(master.getPlayer2().getOwnBoard(), true),
                                        Converter.createShootMap(master.getPlayer1().getOwnBoard(), false));
                break;
            case HIT:
            case MISS:
                msg = new HitMessage(currentState, Converter.createShootMap(master.getPlayer2().getOwnBoard(), true));
                break;
            case WIN1:
            case WIN2:
                msg = createWinMessage(currentState);
                break;
            default: break;
        }
        this.send(msg);
    }
    
    private void updatePlayerTwo() {
        Message msg = null;
        State currentState = master.getCurrentState();
        switch(currentState) {
            case GETNAME1: msg = new WaitMessage(); break;
            case GETNAME2: msg = new GetNameMessage(); break;
            case PLACE1:
            case FINALPLACE1:
                msg = new WaitMessage();
                break;
            case PLACE2: 
            case FINALPLACE2:    
                msg = new ShipMessage(currentState, Converter.createShipMap(master.getPlayer2().getOwnBoard())); 
                break;
            case SHOOT1:
                msg = new WaitMessage();
                break;
            case SHOOT2:
                msg = new ShootMessage(currentState,
                                        Converter.createShootMap(master.getPlayer1().getOwnBoard(), true),
                                        Converter.createShootMap(master.getPlayer2().getOwnBoard(), false));
                break;
            case HIT:
            case MISS:
                msg = new HitMessage(currentState, Converter.createShootMap(master.getPlayer1().getOwnBoard(), true));
                break;
            case WIN1:
            case WIN2:
                msg = createWinMessage(currentState);
                break;
            default: break;
        }
        this.send(msg);
    }
    
     private void placeShip(String[] field) {
        if (isPlayerOne && master.getCurrentState() == State.PLACE1 ||
            !isPlayerOne && master.getCurrentState() == State.PLACE2) {
                
            master.placeShip(Integer.parseInt(field[0]), Integer.parseInt(field[1]), field[2].equals(HORIZONTAL_ORIENTATION));
        }
    }
    
    private void shoot(String[] field) {
        if (isPlayerOne && master.getCurrentState() == State.SHOOT1 ||
            !isPlayerOne && master.getCurrentState() == State.SHOOT2) {
            master.shoot(Integer.parseInt(field[0]), Integer.parseInt(field[1]));
        }
        // else -> the player isn't allowed to shoot in this state
        // instruction is omitted
    }
    
    private WinMessage createWinMessage(State currentState) {
        boolean win = (currentState == State.WIN1 && isPlayerOne) ? true : false;
        Map<Integer, Map<Integer, Character>> ownMap = Converter.createShootMap(master.getPlayer1().getOwnBoard(), false);
        Map<Integer, Map<Integer, Character>> opponentMap = Converter.createShootMap(master.getPlayer2().getOwnBoard(), false);
        
        if(isPlayerOne) 
            return new WinMessage(currentState, win, ownMap, opponentMap);
        else
            return new WinMessage(currentState, win, opponentMap, ownMap);
    }
}