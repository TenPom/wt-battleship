
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/conf/routes
// @DATE:Tue Jan 10 12:40:22 CET 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
