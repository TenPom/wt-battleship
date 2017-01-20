package models.messages;

public class ChatMessage extends Message {
    
    private final String message;
    private final String sender;

    public ChatMessage(String message, String sender) {
        this.type = "CHAT";
        this.message = message;
        this.sender = sender;
    }
}