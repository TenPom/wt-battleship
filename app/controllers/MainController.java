package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import de.htwg.battleship.Battleship;
import de.htwg.battleship.aview.tui.TUI;
import de.htwg.battleship.controller.IMasterController;

public class MainController extends Controller {
	
	static IMasterController controller = Battleship.getInstance().getController();
	
	public Result login() {
	    return ok(views.html.login.render());
	}
	
	public Result battleship() {
	    return ok(views.html.battleship.render(controller));
	}
	
	public Result rules() {
	    return ok(views.html.rules.render());
	}

	public Result wuiTuiInterface(String command) {
		TUI tui = Battleship.getInstance().getTui();
		tui.processInputLine(command);
		return ok("" + tui.getTuiOutput());
//		return ok(tui.toHTML());
	}
}