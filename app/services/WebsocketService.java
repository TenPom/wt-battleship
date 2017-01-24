package services;

import java.util.List;
import java.util.LinkedList;

import play.mvc.WebSocket;
import services.WebsocketService;

import models.GameInstance;
import controllers.WuiController;

import akka.actor.*;

import de.htwg.battleship.Battleship;

public class WebsocketService extends UntypedActor {
    
    private static final List<GameInstance> soloGame = new LinkedList<>();
    
    private GameInstance instance;
    private WuiController wuiController;
    
    public static Props props(ActorRef out) {
        return Props.create(WebsocketService.class, out);
    }

    public WebsocketService(ActorRef out) {
        if (soloGame.isEmpty()) {
            // first player
            Battleship battleship = Battleship.getInstance(true);
            this.wuiController = new WuiController(battleship.getController(), out, true);
            this.instance = new GameInstance(battleship, out, this.wuiController);
            soloGame.add(this.instance);
        } else {
            // second player
            this.instance = soloGame.get(0);
            soloGame.remove(0);
            this.instance.setSocketTwo(out);
            this.wuiController =
                new WuiController(this.instance.getInstance().getController(), out, false);
            this.instance.setWuiControllerTwo(this.wuiController);
            this.wuiController.startGame();
        }
    }

    public void onReceive(Object message) throws Exception {
        this.wuiController.handleMessage((String)message);
    }
}