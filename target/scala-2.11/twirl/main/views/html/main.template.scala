
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
    <link rel="shortcut icon" href='../assets/icon.jpg' type="image/x-icon" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="../assets/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    
    <script src=""""),_display_(/*15.19*/routes/*15.25*/.Assets.versioned("polymer/bower_components/webcomponentsjs/webcomponents-lite.js")),format.raw/*15.108*/(""""></script>
   	<link rel="import" href=""""),_display_(/*16.31*/routes/*16.37*/.Assets.versioned("polymer/bower_components/polymer/polymer.html")),format.raw/*16.103*/("""">
   	<link rel="import" href=""""),_display_(/*17.31*/routes/*17.37*/.Assets.versioned("polymer/src/battleship-app/battleship-app.html")),format.raw/*17.104*/("""">
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
              <li><a id="menuBar" href="battleship">Start new Game</a></li>
              <li><a id="menuBar" href="#">Restore last Game</a></li>
              <li><a id="menuBar" href="rules">Rules</a></li>
            </ul>
          </div>
        </nav>
    </div>
    <div class="container">
        <p><img id = "backgroundPicIndex" src ="../assets/battleship.png" alt="battleship_background"></p>
        """),_display_(/*37.10*/content),format.raw/*37.17*/("""
    """),format.raw/*38.5*/("""</div>
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
                  DATE: Wed Jan 11 18:01:43 CET 2017
                  SOURCE: C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/app/views/main.scala.html
                  HASH: 6ba02f60c8200d7a2606e8fa2707eef0c2dc0114
                  MATRIX: 748->1|873->31|903->35|1051->157|1076->162|1593->652|1608->658|1713->741|1783->784|1798->790|1886->856|1947->890|1962->896|2051->963|2844->1729|2872->1736|2905->1742
                  LINES: 27->1|32->1|34->3|38->7|38->7|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|68->37|68->37|69->38
                  -- GENERATED --
              */
          