package services;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

public class AuthenticationService extends Security.Authenticator {

        @Override
        public String getUsername(Http.Context ctx) {
            System.out.println("bla:: " + ctx.session().get("email"));
            return ctx.session().get("email");
        }

        @Override
        public Result onUnauthorized(Http.Context ctx) {
            return redirect(controllers.routes.AuthenticationController.login());
        }
    }