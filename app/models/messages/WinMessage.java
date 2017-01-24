package models.messages;

import java.util.Map;
import de.htwg.battleship.util.State;

public class WinMessage extends Message {
    
    boolean win;
    Map<Integer, Map<Integer, Character>> ownMap;
    Map<Integer, Map<Integer, Character>> opponentMap;
    
    public WinMessage(State type, boolean win, Map<Integer, Map<Integer, Character>> ownMap, Map<Integer, Map<Integer, Character>> opponentMap) {
        this.type = type.toString();
        this.win = win;
        this.ownMap = ownMap;
        this.opponentMap = opponentMap;
    }
}