package controllers;

import de.htwg.battleship.controller.IMasterController;
import de.htwg.battleship.observer.IObserver;
import de.htwg.battleship.util.State;
import models.User;
import models.GameInstance;
import models.messages.*;
import play.mvc.WebSocket;


public class WuiController implements IObserver {
    
    private static final String HORIZONTAL_ORIENTATION = "true";
    private static final String PLAYERNAME_PREFIX = "PLAYERNAME ";
    
    private GameInstance gameInstance;
    private IMasterController master;
    private WebSocket.Out<String> socket;
    private boolean isPlayerOne;
    
    public WuiController(IMasterController master, WebSocket.Out<String> socket, boolean isPlayerOne) {
        this.master = master;
        this.socket = socket;
        this.isPlayerOne = isPlayerOne;
        master.addObserver(this);
        System.out.println("WuiController initialized!");
        send(new ChatMessage("ChatNachricht 1", "testSender"));
    }
    
    public void setGameInstance(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
    }
    
    public void chat(ChatMessage message) {
        this.send(message);
    }
    
    private void send(Message msg) {
        System.out.println("[Send Message from: " + this + " to socket: " + socket + "]");
        if (msg != null && socket != null) {
            socket.write(msg.toJSON());
        }
    }
    
    public void startGame() {
        this.master.startGame();
    }
    
    public void setProfile(String name, String id) {
        this.master.setPlayerProfile(name, id);
    }
    
     public void handleMessage(String message) {
        System.out.println("Incoming message from Client: " + message);
        
        if (message.startsWith(GameInstance.CHAT_PREFIX)) {
            this.gameInstance.chat(message, isPlayerOne);
            return;
        }
        
        if(message.startsWith(PLAYERNAME_PREFIX)) {
            String[] name = message.split(" ");
            System.out.println("## Set Playername to: " + name[1]);
            master.setPlayerName(name[1]);
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
           System.out.println("[GameUpdate] -- Player: " + master.getPlayer1().getName());
           System.out.println("[GameUpdate] -- State:  " + master.getCurrentState());
           updatePlayerOne();
       } else {
           System.out.println("[GameUpdate] -- Player: " + master.getPlayer2().getName());
           System.out.println("[GameUpdate] -- State:  " + master.getCurrentState());
           updatePlayerTwo();
       }
    }
    
    private void updatePlayerOne() {
        Message msg = null;
        State currentState = master.getCurrentState();
        switch(currentState) {
            case GETNAME1: msg = new GetNameMessage(); break;
            default: break;
        }
        this.send(msg);
    }
    
    private void updatePlayerTwo() {
        Message msg = null;
        State currentState = master.getCurrentState();
        switch(currentState) {
            case GETNAME2: msg = new GetNameMessage(); break;
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
}