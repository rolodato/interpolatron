package ar.edu.utn.superior.interpolatron.ui

import scala.swing._

class ValorCoordenada(d: String) extends BoxPanel(Orientation.Horizontal) {
  val label = new Label(d)
  val input = new TextField()
  contents ++= Seq(label, input)
}