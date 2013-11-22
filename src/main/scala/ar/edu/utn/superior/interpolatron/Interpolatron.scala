package ar.edu.utn.superior.interpolatron

import scala.collection.JavaConverters.seqAsJavaListConverter
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException

@Observable
class Interpolatron {

  var puntos = List[Punto]()

  // Diferencias divididas progresivas
  private def difDiv(puntos: List[Punto]): Double = {
    puntos match {
      case Nil => 0 // Evitar warning
      case p :: Nil => p.y
      case p :: ps => (difDiv(puntos.tail) - difDiv(puntos.init)) / (puntos.last.x - puntos.head.x)
    }
  }

  private def diferenciaDivididaProg(n: Integer) = difDiv(puntos.toList take n)

  def diferenciaDivididaReg(n: Integer) = difDiv(puntos.toList takeRight n)

  private def abscisas = puntos map { p => p.x }

  private def verificarRepetido(punto: Punto) {
    if (abscisas contains punto.x) {
      throw new UserException("Ya existe un punto con la misma abscisa.")
    }
  }

  def diferenciasDivididas = {
    if (puntos isEmpty) throw new UserException("No se ingresó ningún punto.")
    (1 to puntos.size) map { i => diferenciaDivididaProg(i) }
  }

  //P(x) = a0 + a1.(X-X0) + a2.(X-X0).(X-X1) + … + an.(X-X0).(X-X1)…(X-Xn-1) (Progresivo)
  //P(x) = b0 + b1.(X-Xn) + b2.(X-Xn).(X-Xn-1) + … + bn.(X-Xn).(X-Xn-1)…(X-X1) (Regresivo)
  def armarPolinomioProgresivo: String = {
    "P(x) = " + progresivo(puntos.size)
  }

  def armarPolinomioRegresivo: String = {
    "P(x) = " + regresivo(puntos.size)
  }

  def progresivo(n: Int): String = n match {
    case 1 => diferenciaDivididaProg(1).toString
    case _ => progresivo(n - 1) + " + " + diferenciaDivididaProg(n) + armarProductoProg(n - 2)
  }

  def regresivo(n: Int): String = n match {
    case 1 => diferenciaDivididaReg(n).toString
    case _ => regresivo(n - 1) + " + " + diferenciaDivididaReg(n) + armarProductoReg(n - 2)
  }

  def armarProductoProg(n: Int): String = n match {
    case 0 => valorX(0)
    case _ => armarProductoProg(n - 1) + valorX(n)
  }

  def armarProductoReg(n: Int): String = n match {
    case 0 => valorX(puntos.size - 1)
    case _ => armarProductoReg(n - 1) + valorX(puntos.size - (n + 1))
  }

  def valorX(n: Int): String = ".(x-" + puntos(n).x + ")"

  // UI
  var x: Double = _
  var y: Double = _

  var puntoSeleccionado: Punto = _

  def getPuntos = puntos.sortBy { p => p.x }.asJava

  private def puntoIngresado = new Punto(x, y)

  def agregar {
    verificarRepetido(puntoIngresado)
    puntos ::= puntoIngresado
  }

  def quitar { puntos = puntos filter { _ != puntoSeleccionado } }

  def reset { x = 0; y = 0; puntos = List() }

}
