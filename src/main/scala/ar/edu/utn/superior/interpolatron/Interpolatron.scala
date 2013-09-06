package ar.edu.utn.superior.interpolatron

class Interpolatron {
	type Punto = Tuple2[Double, Double]
	private var puntos = Set[Punto]()

	private def difDiv(xi: List[Punto]): Double = {
		xi match {
			case Nil => 0 // Evitar warning
			case x :: Nil => x._2
			case x :: xs => (difDiv(xi.tail) - difDiv(xi.init)) / (xi.last._1- xi.head._1)
		}
	}

	private def diferenciaDividida(n: Integer) = difDiv(puntos.toList take n)
	
	private def abscisas = puntos map {p => p._1}
	
	private def verificarRepetido(punto: Punto) {
	  if (abscisas contains punto._1) {
	    throw new PuntoDuplicadoException
	  }
	} 

	def diferenciasDivididas = {
	  if (puntos isEmpty) throw new NingunPuntoIngresadoException
	  (1 to puntos.size) map {i => diferenciaDividida(i)}
	}
	
	def agregar(punto: Punto) = { verificarRepetido(punto); puntos += punto; this }
	def quitar(punto: Punto) = { puntos -= punto; this }
}

class NingunPuntoIngresadoException extends RuntimeException
class PuntoDuplicadoException extends RuntimeException