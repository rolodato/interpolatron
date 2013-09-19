package ar.edu.utn.superior.interpolatron

import scala.collection.mutable.SortedSet
import org.uqbar.commons.utils.Observable
import scala.collection.JavaConverters._

@Observable
class Interpolatron {
  
	var puntos = List[Punto]()
	
	// Diferencias divididas progresivas
	private def difDiv(puntos: List[Punto]): Double = {
		puntos match {
			case Nil => 0 // Evitar warning
			case p :: Nil => p.y
			case p :: ps => (difDiv(puntos.tail) - difDiv(puntos.init)) / (ps.last.x - ps.head.x)
		}
	}

	private def diferenciaDividida(n: Integer) = difDiv(puntos.toList take n)
	
	private def abscisas = puntos map {p => p.x}
		
	private def verificarRepetido(punto: Punto) {
	  if (abscisas contains punto.x) {
	    throw new PuntoDuplicadoException
	  }
	}
	
	def diferenciasDivididas = {
	  if (puntos isEmpty) throw new NingunPuntoIngresadoException
	  (1 to puntos.size) map {i => diferenciaDividida(i)}
	}
	
	// UI
	var x: Double = _
	var y: Double = _
	
	def getPuntos = puntos.sortBy{p => p.x}.asJava
	
	private def puntoIngresado = new Punto(x, y)
	
	def agregar { verificarRepetido(puntoIngresado); puntos ::= puntoIngresado }
	//def quitar { puntos -= puntoIngresado }
	
}

class NingunPuntoIngresadoException extends RuntimeException
class PuntoDuplicadoException extends RuntimeException
