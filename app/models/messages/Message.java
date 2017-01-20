package models.messages;

import com.google.gson.Gson;

public abstract class Message {
    
    protected String type;

    public String toJSON() {
        return new Gson().toJson(this);
    }
}