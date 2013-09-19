package ar.edu.utn.superior.interpolatron.ui

import ar.edu.utn.superior.interpolatron.Interpolatron
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.tables.Table
import ar.edu.utn.superior.interpolatron.Punto
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.widgets.RadioSelector
import scala.collection.JavaConverters._

class InterpolatronWindow(parent: WindowOwner) extends SimpleWindow(parent, new Interpolatron) {
  
  override def createMainTemplate(mainPanel: Panel) = {
    this.setTitle("TP Matemática Superior 2C 2013")
    this.setTaskDescription("Calculadora de polinomios interpoladores utilizando Newton-Gregory")
    super.createMainTemplate(mainPanel)
  }
  
  override def createFormPanel(mainPanel: Panel) = {
    val tabla = new Table[Punto](mainPanel, classOf[Punto])
    tabla.setHeigth(300)
    tabla.bindItemsToProperty("puntos")
    
    val abscisas = new Column[Punto](tabla)
    abscisas.setTitle("X").bindContentsToProperty("x")
    
    val ordenadas = new Column[Punto](tabla)
    ordenadas.setTitle("Y").bindContentsToProperty("y")
    
    val label_x = new Label(mainPanel).setText("x")
    val input_x = new TextBox(mainPanel).bindValueToProperty("x")
    val label_y = new Label(mainPanel).setText("y")
    val input_y = new TextBox(mainPanel).bindValueToProperty("y")
    
    val modoRadio = new RadioSelector(mainPanel).setContents(List("Progresivo", "Regresivo").asJava, "Modo")
    
  }
  
  override def addActions(actionsPanel: Panel) = {
    val boton_agregar = new Button(actionsPanel)
    boton_agregar.setCaption("Agregar punto")
    boton_agregar.onClick(new MessageSend(getModelObject, "agregar"))
    
    val boton_calcular = new Button(actionsPanel)
    boton_calcular.setCaption("Calcular polinomio")
  }
}