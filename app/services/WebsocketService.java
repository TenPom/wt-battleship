package services;

import java.util.List;
import java.util.LinkedList;

import play.mvc.WebSocket;

import models.GameInstance;
import controllers.WuiController;

import de.htwg.battleship.Battleship;

public class WebsocketService {
    
    private static final List<GameInstance> soloGame = new LinkedList<>();
    
    private boolean isPlayerOne;
    private GameInstance instance;
    private WuiController wuiController;
    
    public void startWebsocket(WebSocket.In<String> in, WebSocket.Out<String> out, final String login, final String id) {
        System.out.println("start called .. login: " + login + " id: " + id);
        if (soloGame.isEmpty()) {
            // first player
            Battleship battleship = Battleship.getInstance(true);
            this.wuiController = new WuiController(battleship.getController(), out, true);
            this.instance = new GameInstance(battleship, out, this.wuiController);
            soloGame.add(this.instance);
            this.wuiController.startGame();
            isPlayerOne = true;
        } else {
            // second player
            this.instance = soloGame.get(0);
            soloGame.remove(0);
            this.instance.setSocketTwo(out);
            this.wuiController =
                new WuiController(this.instance.getInstance().getController(), out, false);
            this.instance.setWuiControllerTwo(this.wuiController);
            isPlayerOne = false;
        }
        
        this.wuiController.setProfile(login, id);

        in.onMessage((String message) -> this.wuiController.handleMessage(message));

        in.onClose(() -> {
            System.out.println("websocket closed ..");
            soloGame.remove(this.instance);
        });
    }
}