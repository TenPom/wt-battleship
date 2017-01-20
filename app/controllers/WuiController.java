package controllers;

import de.htwg.battleship.controller.IMasterController;
import de.htwg.battleship.observer.IObserver;
import models.User;
import models.GameInstance;
import models.messages.Message;
import models.messages.ChatMessage;
import play.mvc.WebSocket;


public class WuiController implements IObserver {
    
    private GameInstance gameInstance;
    private IMasterController master;
    private WebSocket.Out<String> socket;
    private boolean isPlayerOne;
    
     @Override
    public void update() {
       
    }
    
    public WuiController(IMasterController master, WebSocket.Out<String> socket, boolean isPlayerOne) {
        this.master = master;
        this.socket = socket;
        this.isPlayerOne = isPlayerOne;
        master.addObserver(this);
    }
    
    public void setGameInstance(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
    }
    
    public void chat(ChatMessage message) {
        this.send(message);
    }
    
     private void send(Message msg) {
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
    
     public void analyzeMessage(String message) {
        if (message.startsWith(GameInstance.CHAT_PREFIX)) {
            this.gameInstance.chat(message, isPlayerOne);
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
}