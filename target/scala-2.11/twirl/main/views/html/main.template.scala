
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>"""),_display_(/*7.13*/title),format.raw/*7.18*/("""</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="shortcut icon" href='../assets/icon.jpg' type="image/x-icon" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="../assets/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    
    <script src=""""),_display_(/*16.19*/routes/*16.25*/.Assets.versioned("polymer/bower_components/webcomponentsjs/webcomponents-lite.js")),format.raw/*16.108*/(""""></script>
   	<link rel="import" href=""""),_display_(/*17.31*/routes/*17.37*/.Assets.versioned("polymer/bower_components/polymer/polymer.html")),format.raw/*17.103*/("""">
   	<link rel="import" href=""""),_display_(/*18.31*/routes/*18.37*/.Assets.versioned("polymer/src/battleship-app/battleship-app.html")),format.raw/*18.104*/("""">
</head>
<body>
    <div>
        <nav id="navBar" class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand">Battleship</a>
            </div>
            <ul class="nav navbar-nav">
              <li><a id="menuBar" href="/">Home</a></li>
              <li><a id="menuBar" href="/battleship">Start new Game</a></li>
              <li><a id="menuBar" href="#">Restore last Game</a></li>
              <li><a id="menuBar" href="/rules">Rules</a></li>
            </ul>
          </div>
        </nav>
    </div>
    <div><img id = "backgroundPicIndex" src ="../assets/battleship.png" alt="battleship_background"></div>
    <div class="content">
        """),_display_(/*38.10*/content),format.raw/*38.17*/("""
    """),format.raw/*39.5*/("""</div>
</body>
</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Fri Jan 13 14:17:57 CET 2017
                  SOURCE: C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/app/views/main.scala.html
                  HASH: fa02b505c233302764310decc27f31f3862a2b60
                  MATRIX: 748->1|873->31|903->35|1051->157|1076->162|1711->770|1726->776|1831->859|1901->902|1916->908|2004->974|2065->1008|2080->1014|2169->1081|2962->1847|2990->1854|3023->1860
                  LINES: 27->1|32->1|34->3|38->7|38->7|47->16|47->16|47->16|48->17|48->17|48->17|49->18|49->18|49->18|69->38|69->38|70->39
                  -- GENERATED --
              */
          