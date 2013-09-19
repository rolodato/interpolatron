package ar.edu.utn.superior.interpolatron.ui

import ar.edu.utn.superior.interpolatron.Interpolatron
import ar.edu.utn.superior.interpolatron.Punto
import scala.collection.JavaConverters._
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.layout.HorizontalLayout

class InterpolatronWindow(parent: WindowOwner) extends SimpleWindow(parent, new Interpolatron) {
  
  override def createMainTemplate(mainPanel: Panel) = {
    this.setTitle("TP Matemática Superior 2C 2013")
    this.setTaskDescription("Método de Newton-Gregory")
    super.createMainTemplate(mainPanel)
  }
  
  override def createFormPanel(mainPanel: Panel) = {
    
    val controles_borrar = new Panel(mainPanel)
    controles_borrar.setLayout(new HorizontalLayout)
    
    val boton_quitar = new Button(controles_borrar)
    boton_quitar.setCaption("Quitar seleccionado")
    boton_quitar.onClick(new MessageSend(getModelObject, "quitar"))
    
    val boton_reset = new Button(controles_borrar)
    boton_reset.setCaption("Quitar todos")
    boton_reset.onClick(new MessageSend(getModelObject, "reset"))
    
    val tabla = new Table[Punto](mainPanel, classOf[Punto])
    tabla.setHeigth(200)
    tabla.bindItemsToProperty("puntos")
    tabla.bindValueToProperty("puntoSeleccionado")
    
    val abscisas = new Column[Punto](tabla)
    abscisas.setTitle("X").bindContentsToProperty("x")
    
    val ordenadas = new Column[Punto](tabla)
    ordenadas.setTitle("Y").bindContentsToProperty("y")
    
    // TODO: Ver como funciona esto
    val modoRadio = new RadioSelector(mainPanel).setContents(List("Progresivo", "Regresivo").asJava, "Modo")
    
    val inputX = new CoordenadaInput(mainPanel, "x")
    val inputY = new CoordenadaInput(mainPanel, "y")
        
  }
  
  override def addActions(actionsPanel: Panel) = {
    val boton_agregar = new Button(actionsPanel)
    boton_agregar.setCaption("Agregar punto")
    boton_agregar.onClick(new MessageSend(getModelObject, "agregar"))
    boton_agregar.disableOnError
    
    
    val boton_calcular = new Button(actionsPanel)
    boton_calcular.setCaption("Calcular polinomio")
  }
}