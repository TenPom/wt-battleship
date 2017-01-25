package controllers;

import models.GameInstance;
import models.User;
import services.UserService;
import services.AuthenticationService;

import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Optional;
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

import akka.actor.*;

import play.routing.JavaScriptReverseRouter;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;

import de.htwg.battleship.Battleship;
import de.htwg.battleship.aview.tui.TUI;
import de.htwg.battleship.controller.IMasterController;

public class MainController extends Controller {
	
	private static Result LOGIN = redirect(routes.AuthenticationController.login());
	
    private static UserService userService = UserService.getInstance();
	
	private static Map<String, IMasterController> controllers = new HashMap<>();
	
	private static Map<String, String> users = new HashMap<>();
	
	@play.mvc.Security.Authenticated(AuthenticationService.class)
	public Result battleship() {
	    String email = session("email");
	    
	    System.out.println(session("google") + " email: " + email);
	    if (null != session("google")) {
            return ok(views.html.battleship.render(email));
        }
        
        Optional<User> user = userService.getUserByMail(email);
        System.out.println(user.isPresent());
        if (!user.isPresent()) {
            session().clear();
            return LOGIN;
        }
	    return ok(views.html.battleship.render(email));
	}
	
	public Result rules() {
	    return ok(views.html.rules.render());
	}
   
    public Result jsRoutes() {
        return ok(
            JavaScriptReverseRouter.create("jsRoutes",
                routes.javascript.AuthenticationController.googleLogin(),
                routes.javascript.AuthenticationController.logout())
            ).as("text/javascript");
    }
	
	 public LegacyWebSocket<String> webSocket() {
	    return WebSocket.withActor(services.WebsocketService::props);
	 }
	
	//---------------------- Hilfsklassen -----------------------------
	
	
	
}