package models.messages;

import java.util.Map;
import de.htwg.battleship.util.State;

public class ShootMessage extends Message {
    
    Map<Integer, Map<Integer, Character>> ownMap;
    Map<Integer, Map<Integer, Character>> opponentMap;
    
    public ShootMessage(State type, Map<Integer, Map<Integer, Character>> ownMap, Map<Integer, Map<Integer, Character>> opponentMap) {
        this.type = type.toString();
        this.ownMap = ownMap;
        this.opponentMap = opponentMap;
    } 
}