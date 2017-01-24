package models.messages;

import java.util.Map;
import de.htwg.battleship.util.State;

public class HitMessage extends Message {
    
    Map<Integer, Map<Integer, Character>> hitMap;
    
    public HitMessage(State type, Map<Integer, Map<Integer, Character>> hitMap) {
        this.type = type.toString();
        this.hitMap = hitMap;
    }
}