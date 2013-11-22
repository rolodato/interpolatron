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
import org.uqbar.arena.windows.Dialog
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.arena.layout.VerticalLayout

class EvaluarWindow(parent: WindowOwner, model: Interpolatron) extends SimpleWindow(parent, model: Interpolatron) {

  override def createMainTemplate(mainPanel: Panel) = {
    this.setTitle("TP Matemática Superior 2C 2013")
    this.setTaskDescription("Evaluar polinomio")
    super.createMainTemplate(mainPanel)
  }

  override def createFormPanel(mainPanel: Panel) = {

    val progresivo = new Label(mainPanel).setText(getModelObject.armarPolinomioProgresivo + " (progresivo)")
    val regresivo = new Label(mainPanel).setText(getModelObject.armarPolinomioRegresivo + " (regresivo)")
    val grado = new Label(mainPanel).setText("Grado: " + getModelObject.conocerGrado)

    val inputX = new CoordenadaInput(mainPanel, "x_eval")
    inputX.label.setText("x")
    inputX.setWidth(500)
  }

  override def addActions(actionsPanel: Panel) = {
    actionsPanel.setLayout(new VerticalLayout)
    val boton_evaluar = new Button(actionsPanel)
    boton_evaluar.setCaption("Evaluar polinomio")
    	.onClick(new MessageSend(getModelObject, "evaluar"))
    	.setWidth(500)
    
    val resultado = new Label(actionsPanel)
    resultado.bindValueToProperty("evaluar_resultado")
  }
  
  
}