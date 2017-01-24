package models.messages;

import java.util.Map;
import de.htwg.battleship.util.State;

public class ShipMessage extends Message {
    
    Map<Integer, Map<Integer, Character>> boardmap;
    
    public ShipMessage(State type, Map<Integer, Map<Integer, Character>> map) {
        this.type = type.toString();
        this.boardmap = map;
    }
}