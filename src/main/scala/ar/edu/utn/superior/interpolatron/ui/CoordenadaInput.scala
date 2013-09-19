package ar.edu.utn.superior.interpolatron.ui

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.layout.HorizontalLayout

class CoordenadaInput(panel: Panel, coordenada: String) extends Panel(panel) {
  this.setLayout(new HorizontalLayout)
  val label = new Label(this).setText(coordenada)
  val input = new TextBox(this).setWidth(200).bindValueToProperty(coordenada)

}