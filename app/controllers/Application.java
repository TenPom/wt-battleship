package controllers;

import de.htwg.battleship.Battleship;
import de.htwg.battleship.aview.tui.TUI;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	public Result index() {
		return ok("TOll!!");
	}

	public Result wuiTuiInterface(String command) {
		TUI tui = Battleship.getInstance().getTui();
		tui.processInputLine(command);
		return ok("" + tui.getTuiOutput());
//		return ok(tui.toHTML());
	}
	
//	public Result startGame() {
//		Battleship.main(new String[0]);
//		return ok("Spiel startet..");
//	}

}