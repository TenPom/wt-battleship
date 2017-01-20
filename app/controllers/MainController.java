package controllers;

import utils.WebsocketUtils;
import models.GameInstance;

import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.concurrent.CompletionStage;

import play.mvc.Result;
import play.mvc.Security;
import play.mvc.WebSocket;
import play.mvc.Controller;
import play.mvc.Http.Context;
import play.mvc.LegacyWebSocket;

import play.data.Form;
import play.data.DynamicForm;

import play.libs.F;
import play.libs.Json;
import play.libs.openid.*;

import play.routing.JavaScriptReverseRouter;

import services.WebsocketService;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;

import de.htwg.battleship.Battleship;
import de.htwg.battleship.aview.tui.TUI;
import de.htwg.battleship.controller.IMasterController;

public class MainController extends Controller {
	
	
	
	private static Map<String, IMasterController> controllers = new HashMap<>();
	
	private static Map<String, String> users = new HashMap<>();
	
	private final WebsocketService websocketService = new WebsocketService();
	
	@play.mvc.Security.Authenticated(Secured.class)
	public Result battleship() {
	    String email = session("email");
	    IMasterController controller = controllers.get(email);
	    System.out.println("controller: " + controller + "\tUser: " + email);
	    if(null == controller) {
	        session().clear();
	        System.out.println("session " + email + " clear!!!!!!!!!!!!!!!!!");
	        return this.login();
	    }
	    return ok(views.html.battleship.render(controller, email));
	}
	
	public Result login() {
	    return ok(views.html.login.render(Form.form(User.class)));
	}
	
	public Result logout() {
        String email = session("email");
        controllers.remove(email);
    	session().clear();
    	return redirect(routes.MainController.battleship());
    }
	
	 public Result signupForm() {
        return ok(views.html.signup.render(Form.form(User.class)));
    }
	
	public Result rules() {
	    return ok(views.html.rules.render());
	}

	public Result wuiTuiInterface(String command) {
	    System.out.println("wuiTuimethode");
	    System.out.println("instanz: " + Battleship.getInstance());
		TUI tui = Battleship.getInstance().getTui();
		tui.processInputLine(command);
		String email = session("email");
		System.out.println("SESSION_EMAIL: " + email);
	    IMasterController controller = controllers.get(email);
	    System.out.println("\n\n\ncommandfunktion: " + controller + "\n\n\n");
		return ok(views.html.battleship.render(controller, email));
	}
	
	public Result jsonCommand(String command) {
	    String email = session("email");
        IMasterController controller = controllers.get(email);
        System.out.println("jsonCommand: " + command);
        //controller.processInputLine(command);
        return ok(views.html.battleship.render(controller, email));
	}
	
	public Result authenticate() {
        Form<User> loginform = DynamicForm.form(User.class).bindFromRequest();

        User user = User.authenticate(loginform.get());

        if (loginform.hasErrors() || user == null) {
            ObjectNode response = Json.newObject();
            response.put("success", false);
            response.put("errors", loginform.errorsAsJson());
            if (user == null) {
                flash("errors", "Wrong username or password");
            }

            return badRequest(views.html.login.render(loginform));
        } else {
            session().clear();
            session("email", user.email);
            String email = session("email");
            IMasterController controller = Battleship.getInstance().getController();
            System.out.println("Init controller: " + controller);
            controllers.put(email,controller);
            return redirect(routes.MainController.battleship());
        }
    }
    
    public Result signup() {
        Form<User> loginform = DynamicForm.form(User.class).bindFromRequest();

        ObjectNode response = Json.newObject();
        User account = loginform.get();
        boolean exists = users.containsKey(account.email);

        if (loginform.hasErrors() || exists) {
            response.put("success", false);
            response.put("errors", loginform.errorsAsJson());
            if (exists) {
                flash("errors", "Account already exists");
            }

            return badRequest(views.html.signup.render(loginform));
        } else {
            users.put(loginform.get().email, loginform.get().password);
            session().clear();
            session("email", loginform.get().email);
            return redirect(routes.MainController.battleship());
        }
    }
   
    public Result jsRoutes() {
        return ok(
            JavaScriptReverseRouter.create("jsRoutes", 
                routes.javascript.MainController.authenticate(),
                routes.javascript.MainController.logout())
            ).as("text/javascript");
    }
	
	public Result webSocketRender() {
	    return ok(views.js.websocket.render());
	}
	
	 public LegacyWebSocket<String> webSocket() {
	     System.out.println("websocketfunction called... !");
	    return WebSocket.whenReady((in,out) -> websocketService.startWebsocket(in, out, "test", "42"));
	 }
	
	//---------------------- Hilfsklassen -----------------------------
	
	public static class User {
        public String email;
        public String password;

        public User() { }

        private User(final String email, final String password) {
            this.email = email;
            this.password = password;
        }

     	public static User authenticate(User user){
     	    if (user != null && users.containsKey(user.email) && users.get(user.email).equals(user.password)) {
     	        return new User(user.email, user.password);
     	    }

    	    return null;
    	}
   }
	
	
	public static class Secured extends Security.Authenticator {

        @Override
        public String getUsername(Context ctx) {
            return ctx.session().get("email");
        }

        @Override
        public Result onUnauthorized(Context ctx) {
            return redirect(routes.MainController.login());
        }
    }
}