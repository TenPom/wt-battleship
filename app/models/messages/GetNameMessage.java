package models.messages;

public class GetNameMessage extends Message {
    
    public GetNameMessage() {
        this.type = "PLAYERNAME";
    }
}