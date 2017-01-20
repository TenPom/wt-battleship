package models;

import models.messages.ChatMessage;
import play.mvc.WebSocket.Out;
import controllers.WuiController;
import de.htwg.battleship.Battleship;


public class GameInstance {
    
    public static final String CHAT_PREFIX = "CHAT ";
    
    private final Battleship instance;
    
    private final WuiController wc_One;
    
    private final Out socket_One;
    
    private WuiController wc_Two;
    
    private Out socket_Two;
    
    public GameInstance(final Battleship instance, final Out socket_One, final WuiController wuiController_One) {
        this.instance = instance;
        this.wc_One = wuiController_One;
        this.socket_One = socket_One;
        this.wc_One.setGameInstance(this);
    }
    
    public Battleship getInstance() {
        return instance;
    }
    
    public Out getSocketOne() {
        return this.socket_One;
    }
    
    public Out getSocketTwo() {
        return this.socket_Two;
    }
    
    public void setSocketTwo(Out socketTwo) {
        this.socket_Two = socketTwo;
    }
    
    public WuiController getWuiControllerOne() {
        return wc_One;
    }

    public WuiController getWuiControllerTwo() {
        return wc_Two;
    }
    
    public void setWuiControllerTwo(final WuiController wuiControllerTwo) {
        this.wc_Two = wuiControllerTwo;
        this.wc_Two.setGameInstance(this);
    }
    
    public void chat(String message, boolean firstPlayer) {
        String msg = message.replace(GameInstance.CHAT_PREFIX, "");
        ChatMessage msgObject;
        if (firstPlayer) {
            // send by Player one -> name of IPlayer1
            msgObject = new ChatMessage(msg, this.instance.getController().getPlayer1().getName());
        } else {
            // send by Player two -> name of IPlayer2
            msgObject = new ChatMessage(msg, this.instance.getController().getPlayer2().getName());
        }
        this.getWuiControllerOne().chat(msgObject);
        this.getWuiControllerTwo().chat(msgObject);
    }

    
    
    
}