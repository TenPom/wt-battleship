
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
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

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/main("Battleship")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
    """),format.raw/*4.5*/("""<div class="row">
        <div class="col-md-4 col-md-offset-4">
            <h1>Login to Battleship</h1>
             <battleship-app></battleship-app>
        </div>
    </div>

""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Wed Jan 11 18:46:22 CET 2017
                  SOURCE: C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/app/views/login.scala.html
                  HASH: 283e892e4097739f7c536193860e78658e433252
                  MATRIX: 827->5|853->23|892->25|924->31|1142->219
                  LINES: 32->3|32->3|32->3|33->4|40->11
                  -- GENERATED --
              */
          