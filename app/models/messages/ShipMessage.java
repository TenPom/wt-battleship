package models.messages;

import de.htwg.battleship.util.State;

import java.util.Map;
import java.util.Set;

public class ShipMessage extends Message {
    
    Map<Integer, Map<Integer, Character>> boardmap;
    
    public ShipMessage(State type, Map<Integer, Map<Integer, Character>> map) {
        this.type = type.toString();
        this.boardmap = map;
    }
}