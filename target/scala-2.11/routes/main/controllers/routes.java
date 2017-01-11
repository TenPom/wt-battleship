
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/conf/routes
// @DATE:Tue Jan 10 12:40:22 CET 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMainController MainController = new controllers.ReverseMainController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMainController MainController = new controllers.javascript.ReverseMainController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
