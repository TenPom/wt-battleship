package models;

import play.mvc.WebSocket;

public class User {
    public String email;
    public String password;
    public WebSocket.Out<String> socket;

    public User() {
    }

    public User(final String email, final String password) {
        this.email = email;
        this.password = password;
    }
    
    public void addSocket(WebSocket.Out<String> out) {
        this.socket = out;
    }
}