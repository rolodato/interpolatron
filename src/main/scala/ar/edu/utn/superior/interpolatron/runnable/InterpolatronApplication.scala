package ar.edu.utn.superior.interpolatron.runnable

import org.uqbar.arena.Application
import ar.edu.utn.superior.interpolatron.ui.InterpolatronWindow

object InterpolatronApplication extends Application with App {
  override def createMainWindow() = new InterpolatronWindow(this)
  start()
}