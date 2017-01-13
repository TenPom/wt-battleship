
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object battleship_Scope0 {
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

class battleship extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[de.htwg.battleship.controller.IMasterController,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(controller: de.htwg.battleship.controller.IMasterController, tuiOutput: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import _root_.de.htwg.battleship.util.State;

Seq[Any](format.raw/*1.82*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Battleship")/*5.20*/ {_display_(Seq[Any](format.raw/*5.22*/("""

    """),format.raw/*7.5*/("""<script language="JavaScript"> 
        function setCords(col, row) """),format.raw/*8.37*/("""{"""),format.raw/*8.38*/("""
            
            """),format.raw/*10.13*/("""var startCharacter = "a";
            
            row = String.fromCharCode(startCharacter.charCodeAt(0) + row);
            
    	    document.getElementById("horizontal").onclick = function() """),format.raw/*14.69*/("""{"""),format.raw/*14.70*/("""
    	        """),format.raw/*15.14*/("""location.href = "/battleship/" + row + " " + col + " horizontal";
    	    """),format.raw/*16.10*/("""}"""),format.raw/*16.11*/("""
    	    
    	    """),format.raw/*18.10*/("""document.getElementById("vertical").onclick = function() """),format.raw/*18.67*/("""{"""),format.raw/*18.68*/("""
    	        """),format.raw/*19.14*/("""location.href = "/battleship/" + row + " " + col + " vertical";
    	    """),format.raw/*20.10*/("""}"""),format.raw/*20.11*/("""
       	"""),format.raw/*21.9*/("""}"""),format.raw/*21.10*/("""
       	
       	"""),format.raw/*23.9*/("""function shoot(col, row) """),format.raw/*23.34*/("""{"""),format.raw/*23.35*/("""
       	    """),format.raw/*24.13*/("""var startCharacter = "a";
            
            row = String.fromCharCode(startCharacter.charCodeAt(0) + row);
            
            location.href = "/battleship/" + row + " " + col;
       	"""),format.raw/*29.9*/("""}"""),format.raw/*29.10*/("""

        """),format.raw/*31.9*/("""function getPlayerName() """),format.raw/*31.34*/("""{"""),format.raw/*31.35*/("""
       	    """),format.raw/*32.13*/("""var playername = prompt("Please enter your name", "");
       	    
       	    if (null != playername) """),format.raw/*34.37*/("""{"""),format.raw/*34.38*/("""
       	        """),format.raw/*35.17*/("""location.href = "/battleship/" + playername;
       	    """),format.raw/*36.13*/("""}"""),format.raw/*36.14*/("""
       	"""),format.raw/*37.9*/("""}"""),format.raw/*37.10*/("""
    """),format.raw/*38.5*/("""</script>
   
   <div class="row" border="1">
       <p id="commandLine" align="center"> 
            """),_display_(/*42.14*/{controller.getCurrentState() match {
                case State.PLACE1 =>
                    controller.getPlayer1().getName() + " now place the ship with the length of " + (controller.getPlayer1().getOwnBoard().getShips() + 2);
                    
                case State.PLACE2 =>
                    controller.getPlayer2().getName() + " now place the ship with the length of " + (controller.getPlayer2().getOwnBoard().getShips() + 2);
                
                case State.SHOOT1 =>
                    controller.getPlayer1().getName() + " is now at the turn to shoot";
                    
                case State.SHOOT2 =>
                    controller.getPlayer2().getName() + " is now at the turn to shoot";
                    
                case _ =>
                    "Spielstatus konnte nicht abgerufen werden";
            }
            }),format.raw/*58.14*/("""
        """),format.raw/*59.9*/("""</p>
    </div>
       
   
    """),_display_(/*63.6*/for(rowCount <- 0 until 10) yield /*63.33*/ {_display_(Seq[Any](format.raw/*63.35*/("""
        """),format.raw/*64.9*/("""<div class="row">
            <div class="col-md-3 text-center"></div>
            <div class="col-md-6 text-center">
                <div class="btn-group">
                    """),_display_(/*68.22*/for(colCount <- 0 until 10) yield /*68.49*/ {_display_(Seq[Any](format.raw/*68.51*/("""
                            """),format.raw/*69.29*/("""<button type="button" class="btn btn-default" onClick=""""),_display_(/*69.85*/if(controller.getCurrentState() == State.SHOOT1 || controller.getCurrentState() == State.SHOOT2)/*69.181*/ {_display_(Seq[Any](format.raw/*69.183*/("""shoot("""),_display_(/*69.190*/rowCount),format.raw/*69.198*/(""", """),_display_(/*69.201*/colCount),format.raw/*69.209*/(""")""")))}/*69.212*/else/*69.217*/{_display_(Seq[Any](format.raw/*69.218*/("""setCords("""),_display_(/*69.228*/rowCount),format.raw/*69.236*/(""", """),_display_(/*69.239*/colCount),format.raw/*69.247*/(""")""")))}),format.raw/*69.249*/("""">
                                    """),_display_(/*70.38*/rowCount),format.raw/*70.46*/(""" """),_display_(/*70.48*/colCount),format.raw/*70.56*/("""
                            """),format.raw/*71.29*/("""</button>
                    """)))}),format.raw/*72.22*/("""
                """),format.raw/*73.17*/("""</div>
            </div>
            <div class="col-md-3 text-center">
                """),_display_(/*76.18*/if(rowCount == 0 && (controller.getCurrentState == State.PLACE1 || controller.getCurrentState == State.PLACE2))/*76.129*/ {_display_(Seq[Any](format.raw/*76.131*/("""
                    """),format.raw/*77.21*/("""<button type="button" class="btn btn-default" id="horizontal">
                        horizontal
                    </button>

                    <button type="button" class="btn btn-default" id="vertical">
                        vertical
                    </button>
                """)))}),format.raw/*84.18*/("""
            """),format.raw/*85.13*/("""</div>
        </div>
    """)))}),format.raw/*87.6*/("""
    
    """),_display_(/*89.6*/if(controller.getCurrentState() == State.START)/*89.53*/ {_display_(Seq[Any](format.raw/*89.55*/("""
        """),_display_(/*90.10*/controller/*90.20*/.setCurrentState(State.GETNAME1)),format.raw/*90.52*/("""
        """),format.raw/*91.9*/("""<script> 
            while (!document.readyState === "complete");
            getPlayerName();
        </script> 
    """)))}),format.raw/*95.6*/("""
    
    """),_display_(/*97.6*/if(controller.getCurrentState() == State.GETNAME2)/*97.56*/ {_display_(Seq[Any](format.raw/*97.58*/("""
         """),format.raw/*98.10*/("""<script> 
            while (!document.readyState === "complete");
            getPlayerName();
        </script> 
    """)))}),format.raw/*102.6*/("""
    
""")))}))
      }
    }
  }

  def render(controller:de.htwg.battleship.controller.IMasterController,tuiOutput:String): play.twirl.api.HtmlFormat.Appendable = apply(controller,tuiOutput)

  def f:((de.htwg.battleship.controller.IMasterController,String) => play.twirl.api.HtmlFormat.Appendable) = (controller,tuiOutput) => apply(controller,tuiOutput)

  def ref: this.type = this

}


}

/**/
object battleship extends battleship_Scope0.battleship
              /*
                  -- GENERATED --
                  DATE: Thu Jan 12 14:36:17 CET 2017
                  SOURCE: C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/app/views/battleship.scala.html
                  HASH: aa8dc4ffa1009a0776b9d0f3f6e7c17f400472c8
                  MATRIX: 803->1|1022->81|1052->132|1080->135|1106->153|1145->155|1179->163|1275->232|1303->233|1359->261|1586->460|1615->461|1658->476|1762->552|1791->553|1841->575|1926->632|1955->633|1998->648|2100->722|2129->723|2166->733|2195->734|2242->754|2295->779|2324->780|2366->794|2595->996|2624->997|2663->1009|2716->1034|2745->1035|2787->1049|2921->1155|2950->1156|2996->1174|3082->1232|3111->1233|3148->1243|3177->1244|3210->1250|3344->1357|4253->2245|4290->2255|4353->2292|4396->2319|4436->2321|4473->2331|4683->2514|4726->2541|4766->2543|4824->2573|4907->2629|5013->2725|5054->2727|5089->2734|5119->2742|5150->2745|5180->2753|5202->2756|5216->2761|5256->2762|5294->2772|5324->2780|5355->2783|5385->2791|5419->2793|5487->2834|5516->2842|5545->2844|5574->2852|5632->2882|5695->2914|5741->2932|5861->3025|5982->3136|6023->3138|6073->3160|6401->3457|6443->3471|6502->3500|6541->3513|6597->3560|6637->3562|6675->3573|6694->3583|6747->3615|6784->3625|6938->3749|6977->3762|7036->3812|7076->3814|7115->3825|7270->3949
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|37->7|38->8|38->8|40->10|44->14|44->14|45->15|46->16|46->16|48->18|48->18|48->18|49->19|50->20|50->20|51->21|51->21|53->23|53->23|53->23|54->24|59->29|59->29|61->31|61->31|61->31|62->32|64->34|64->34|65->35|66->36|66->36|67->37|67->37|68->38|72->42|88->58|89->59|93->63|93->63|93->63|94->64|98->68|98->68|98->68|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|99->69|100->70|100->70|100->70|100->70|101->71|102->72|103->73|106->76|106->76|106->76|107->77|114->84|115->85|117->87|119->89|119->89|119->89|120->90|120->90|120->90|121->91|125->95|127->97|127->97|127->97|128->98|132->102
                  -- GENERATED --
              */
          