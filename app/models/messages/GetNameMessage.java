package models.messages;

public class GetNameMessage extends Message {
    
    boolean isPlayerOne;
    
    public GetNameMessage() {
        this.type = "PLAYERNAME";
    }
}