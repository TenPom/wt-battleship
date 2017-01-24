package models.messages;

import de.htwg.battleship.util.State;

public class PlaceErrorMessage extends Message {
    
    public PlaceErrorMessage(State type) {
        this.type = type.toString();
    }
}