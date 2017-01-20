package models.messages;

import de.htwg.battleship.util.State;

public class InvalidMessage extends Message {

    public InvalidMessage() {
        this.type = State.WRONGINPUT.toString();
    }

}