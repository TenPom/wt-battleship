
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/conf/routes
// @DATE:Tue Jan 10 12:40:22 CET 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  MainController_0: controllers.MainController,
  // @LINE:12
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    MainController_0: controllers.MainController,
    // @LINE:12
    Assets_1: controllers.Assets
  ) = this(errorHandler, MainController_0, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, MainController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.MainController.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """battleship""", """controllers.MainController.battleship()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rules""", """controllers.MainController.rules()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """battleship/""" + "$" + """command<[^/]+>""", """controllers.MainController.wuiTuiInterface(command:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_MainController_login0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_MainController_login0_invoker = createInvoker(
    MainController_0.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MainController",
      "login",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_MainController_battleship1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("battleship")))
  )
  private[this] lazy val controllers_MainController_battleship1_invoker = createInvoker(
    MainController_0.battleship(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MainController",
      "battleship",
      Nil,
      "GET",
      """""",
      this.prefix + """battleship"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_MainController_rules2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rules")))
  )
  private[this] lazy val controllers_MainController_rules2_invoker = createInvoker(
    MainController_0.rules(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MainController",
      "rules",
      Nil,
      "GET",
      """""",
      this.prefix + """rules"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_MainController_wuiTuiInterface3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("battleship/"), DynamicPart("command", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MainController_wuiTuiInterface3_invoker = createInvoker(
    MainController_0.wuiTuiInterface(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MainController",
      "wuiTuiInterface",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """battleship/""" + "$" + """command<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_MainController_login0_route(params) =>
      call { 
        controllers_MainController_login0_invoker.call(MainController_0.login())
      }
  
    // @LINE:7
    case controllers_MainController_battleship1_route(params) =>
      call { 
        controllers_MainController_battleship1_invoker.call(MainController_0.battleship())
      }
  
    // @LINE:8
    case controllers_MainController_rules2_route(params) =>
      call { 
        controllers_MainController_rules2_invoker.call(MainController_0.rules())
      }
  
    // @LINE:9
    case controllers_MainController_wuiTuiInterface3_route(params) =>
      call(params.fromPath[String]("command", None)) { (command) =>
        controllers_MainController_wuiTuiInterface3_invoker.call(MainController_0.wuiTuiInterface(command))
      }
  
    // @LINE:12
    case controllers_Assets_versioned4_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
