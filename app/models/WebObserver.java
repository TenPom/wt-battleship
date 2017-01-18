package models;

import play.mvc.WebSocket;
import play.mvc.WebSocket.Out;
import de.htwg.battleship.observer.IObserver;
import de.htwg.battleship.controller.IMasterController;

public class WebObserver implements IObserver {
    
    private Out<String> out;
	private IMasterController controller; 
	
    
    public WebObserver(IMasterController controller, WebSocket.Out<String> out) {
        controller.addObserver(this);
		this.controller = controller;
		this.out = out;
    }
    
    @Override
	public void update() {
//		out.write(controller.getGrid().toJson());	
		System.out.println("WUI was updated");
	}
}