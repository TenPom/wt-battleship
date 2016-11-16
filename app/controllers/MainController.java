package controllers;

import de.htwg.battleship.Battleship;
import de.htwg.battleship.aview.tui.TUI;
import play.mvc.Controller;
import play.mvc.Result;

public class MainController extends Controller {
	
	public Result battleship() {
	    return ok(views.html.battleship.render());
	}
	
	public Result game() {
	    return ok(views.html.main.render(views.html.index.render()));
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