package controllers;

import de.htwg.battleship.Battleship;
import de.htwg.battleship.aview.tui.TUI;
import play.mvc.Controller;
import play.mvc.Result;

public class MainController extends Controller {

	public Result index() {
		return ok(views.html.index.render("Index Methode!"));
	}
	
	public Result battleship() {
	    return ok(views.html.battleship.render());
	}

	public Result wuiTuiInterface(String command) {
		TUI tui = Battleship.getInstance().getTui();
		tui.processInputLine(command);
		return ok("" + tui.getTuiOutput());
//		return ok(tui.toHTML());
	}
}