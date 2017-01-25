package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Result;
import play.libs.Json;
import services.UserService;
import views.html.login;
import views.html.signup;
import models.User;
import java.util.Optional;

import com.fasterxml.jackson.databind.node.ObjectNode;

import static play.mvc.Controller.flash;
import static play.mvc.Controller.session;
import static play.mvc.Results.*;

public class AuthenticationController {
    
    private UserService userService = UserService.getInstance();
    
    private static Result HOME = redirect(routes.MainController.battleship());
    
    public Result login() {
	    return ok(views.html.login.render(Form.form(User.class)));
	}
	
	public Result logout() {
    	session().clear();
    	return HOME;
    }
    
    public Result signupForm() {
        return ok(views.html.signup.render(Form.form(User.class)));
    }
    
    public Result authenticate() {
        Form<User> loginform = DynamicForm.form(User.class).bindFromRequest();
        Optional<User> user = Optional.empty();
        if (!loginform.hasErrors()) {
            user = userService.authenticate(loginform.get());
        }
        if (user.isPresent()) {
            session().clear();
            session("email", user.get().email);
            return HOME;
        } else {
            ObjectNode response = Json.newObject();
            response.put("success", false);
            response.put("errors", loginform.errorsAsJson());
            return badRequest(login.render(loginform));
        }
    }
    
    public Result signup() {
        Form<User> loginform = DynamicForm.form(User.class).bindFromRequest();

        ObjectNode response = Json.newObject();
        User account = loginform.get();
        boolean exists = userService.getUser(account).isPresent();

        if (loginform.hasErrors() || exists) {
            response.put("success", false);
            response.put("errors", loginform.errorsAsJson());
            if (exists)
                flash("errors", "Account already exists");
            return badRequest(signup.render(loginform));

        } else {
            userService.addUser(account);
            session().clear();
            session("email", account.email);
            return HOME;
        }
    }
    
    public Result googleLogin(String email) {
        System.out.println("google login: " + email);
        session("google", "true");
        session("email", email);
        return HOME;
    }
}