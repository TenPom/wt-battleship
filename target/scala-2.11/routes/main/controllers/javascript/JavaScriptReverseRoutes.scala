
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/conf/routes
// @DATE:Tue Jan 10 12:40:22 CET 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:6
  class ReverseMainController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def battleship: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MainController.battleship",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "battleship"})
        }
      """
    )
  
    // @LINE:9
    def wuiTuiInterface: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MainController.wuiTuiInterface",
      """
        function(command0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "battleship/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("command", encodeURIComponent(command0))})
        }
      """
    )
  
    // @LINE:8
    def rules: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MainController.rules",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rules"})
        }
      """
    )
  
    // @LINE:6
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MainController.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
