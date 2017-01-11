
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object rules_Scope0 {
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

class rules extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Battleship")/*1.20*/ {_display_(Seq[Any](format.raw/*1.22*/("""
    """),format.raw/*2.5*/("""<div>
        <img id="backgroundPicRulePage" src="battleship.png" alt="eine grafik"> 
    </div>
    <div>
        <div class="row">
            <div class="col-md-12 col-md-offset-1"><h2>The basic rules of Battleship</h2></div>
        </div>

        
        <div class="row">
            <div class="col-md-5 col-md-offset-1"><h3>Objective</h3></div>
            <div class="col-md-5 col-md-offset-1"><h3>Starting a new Game</h3></div>
        </div>

        <div class="row" id="rulePageText">
            <div class="col-md-4 col-md-offset-1">The object of Battleship is to try and sink all of the other player's before they
                sink all of your ships. All of the other player's ships are somewhere on his/her board.
                You try and hit them by calling out the coordinates of one of the squares on the board.
                The other player also tries to hit your ships by calling out coordinates.  Neither you 
                nor the other player can see the other's board so you must try to guess where they are.  
                Each board in the physical game has two grids:  the lower (horizontal) section for the player's 
                ships and the upper part (vertical during play) for recording the player's guesses.
            </div>
            <div class="col-md-4 col-md-offset-2">
                Each player places the 5 ships somewhere on their board. 
                The 5 ships have the size of 2-6 fields. 
                The ships can only be placed vertically or horizontally. 
                Diagonal placement is not allowed. No part of a ship may hang off the edge of the board.  
                Ships may not overlap each other.  No ships may be placed on another ship. 
                Once the guessing begins, the players may not move the ships.
            </div>          
        </div>

    </div>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object rules extends rules_Scope0.rules
              /*
                  -- GENERATED --
                  DATE: Wed Jan 11 18:46:22 CET 2017
                  SOURCE: C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/app/views/rules.scala.html
                  HASH: a5544a9d9df15a16d1b1023fefb038e4f1c50229
                  MATRIX: 827->1|853->19|892->21|924->27
                  LINES: 32->1|32->1|32->1|33->2
                  -- GENERATED --
              */
          