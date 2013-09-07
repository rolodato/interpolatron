package ar.edu.utn.superior.interpolatron.ui

import swing._
import javax.swing.UIManager
import javax.swing.Box
import ar.edu.utn.superior.interpolatron.Interpolatron

object InterpolatronApp extends SimpleSwingApplication {
  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
  
  def top = new MainFrame {
    title = "Interpolatron"
    contents = ui
  }
  
  val interpolatron = new Interpolatron
  
  
  val agregarPunto = new BoxPanel(Orientation.Vertical) {
	  val x = new ValorCoordenada("x")
	  val y = new ValorCoordenada("y")
	  val boton = new Button("Agregar")
	  
	  contents ++= Seq(x, y, boton)
  }
  
  val opciones = new BoxPanel(Orientation.Vertical) {
    val progresivo = new RadioButton("Progresivo")
    val regresivo = new RadioButton("Regresivo")
    val mutex = new ButtonGroup(progresivo, regresivo)
    mutex select progresivo
    val botonCalcular = new Button("Calcular")
    
    contents ++= Seq(progresivo, regresivo, botonCalcular)
  }
  
  val evaluar = new BoxPanel(Orientation.Vertical) {
    val x = new TextField()
    val botonEvaluar = new Button("Evaluar")
    contents ++= Seq(x, botonEvaluar)
  }
  
  val entrada = new BoxPanel(Orientation.Vertical) {
    contents += agregarPunto
    peer.add(Box.createVerticalStrut(50))
    contents += evaluar
    peer.add(Box.createVerticalStrut(50))
    contents += opciones
  }
  
  val ui = new FlowPanel() {
    val tablaValores = new TablaValores()
    
    contents ++= Seq(entrada,
    				 tablaValores)
  }
  
}
