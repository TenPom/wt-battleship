
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


Seq[Any](format.raw/*1.82*/("""

"""),_display_(/*3.2*/main("Battleship")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""

    """),format.raw/*5.5*/("""<script language="JavaScript"> 
        function setCords(row, col) """),format.raw/*6.37*/("""{"""),format.raw/*6.38*/("""
            
            """),format.raw/*8.13*/("""var startCharacter = "a";
            
            row = String.fromCharCode(startCharacter.charCodeAt(0) + row);
            
    	    document.getElementById("horizontal").onclick = function() """),format.raw/*12.69*/("""{"""),format.raw/*12.70*/("""
    	        """),format.raw/*13.14*/("""location.href = "/battleship/" + row + " " + col + " horizontal";
    	    """),format.raw/*14.10*/("""}"""),format.raw/*14.11*/("""
    	    
    	    """),format.raw/*16.10*/("""document.getElementById("vertical").onclick = function() """),format.raw/*16.67*/("""{"""),format.raw/*16.68*/("""
    	        """),format.raw/*17.14*/("""location.href = "/battleship/" + row + " " + col + " vertical";
    	    """),format.raw/*18.10*/("""}"""),format.raw/*18.11*/("""
       	"""),format.raw/*19.9*/("""}"""),format.raw/*19.10*/("""
    """),format.raw/*20.5*/("""</script>
        
    """),_display_(/*22.6*/for(rowCount <- 0 until 9) yield /*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
        """),format.raw/*23.9*/("""<div class="row">
            <div class="col-md-3 text-center"></div>
            <div class="col-md-6 text-center">
                <div class="btn-group">
                    """),_display_(/*27.22*/for(colCount <- 0 until 9) yield /*27.48*/ {_display_(Seq[Any](format.raw/*27.50*/("""
                            """),format.raw/*28.29*/("""<button type="button" class="btn btn-default" onClick="setCords("""),_display_(/*28.94*/rowCount),format.raw/*28.102*/(""", """),_display_(/*28.105*/colCount),format.raw/*28.113*/(""")">
                                    """),_display_(/*29.38*/rowCount),format.raw/*29.46*/(""" """),_display_(/*29.48*/colCount),format.raw/*29.56*/("""
                            """),format.raw/*30.29*/("""</button>
                    """)))}),format.raw/*31.22*/("""
                """),format.raw/*32.17*/("""</div>
            </div>
            <div class="col-md-3 text-center">
                """),_display_(/*35.18*/if(rowCount == 0)/*35.35*/ {_display_(Seq[Any](format.raw/*35.37*/("""
                    """),format.raw/*36.21*/("""<button type="button" class="btn btn-default" id="horizontal">
                        horizontal
                    </button>

                    <button type="button" class="btn btn-default" id="vertical">
                        vertical
                    </button>
                """)))}),format.raw/*43.18*/("""
            """),format.raw/*44.13*/("""</div>
        </div>
    """)))}),format.raw/*46.6*/("""
    
    """),format.raw/*48.5*/("""<div class="row">
        <div class="form-group">
            <label for="tuiOutput">TUI Output:</label>
              <textarea class="form-control" rows="10" id="tuiOutput">"""),_display_(/*51.72*/tuiOutput),format.raw/*51.81*/("""</textarea>
        </div>
    </div>
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
                  DATE: Wed Jan 11 16:03:32 CET 2017
                  SOURCE: C:/Users/Nina/Documents/HTWG Konstanz/6Sem/WebTec/wt-battleship/app/views/battleship.scala.html
                  HASH: 867624c7c9d064ae3aff15feed73fc265d4b760f
                  MATRIX: 803->1|978->81|1008->86|1034->104|1073->106|1107->114|1203->183|1231->184|1286->212|1513->411|1542->412|1585->427|1689->503|1718->504|1768->526|1853->583|1882->584|1925->599|2027->673|2056->674|2093->684|2122->685|2155->691|2207->717|2249->743|2289->745|2326->755|2536->938|2578->964|2618->966|2676->996|2768->1061|2798->1069|2829->1072|2859->1080|2928->1122|2957->1130|2986->1132|3015->1140|3073->1170|3136->1202|3182->1220|3302->1313|3328->1330|3368->1332|3418->1354|3746->1651|3788->1665|3847->1694|3886->1706|4093->1886|4123->1895
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|37->6|37->6|39->8|43->12|43->12|44->13|45->14|45->14|47->16|47->16|47->16|48->17|49->18|49->18|50->19|50->19|51->20|53->22|53->22|53->22|54->23|58->27|58->27|58->27|59->28|59->28|59->28|59->28|59->28|60->29|60->29|60->29|60->29|61->30|62->31|63->32|66->35|66->35|66->35|67->36|74->43|75->44|77->46|79->48|82->51|82->51
                  -- GENERATED --
              */
          