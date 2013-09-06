class Interpolatron {
	type Punto = Tuple2[Double, Double]
	var puntos = Set[Punto]()

	def difDiv(xi: List[Punto]): Double = {
		xi match {
			case Nil => 0 // Evitar warning
			case x :: Nil => x._2
			case x :: xs => (difDiv(xi.tail) - difDiv(xi.init)) / (xi.last._1- xi.head._1)
		}
	}

	def diferenciaDividida(n: Integer) = difDiv(puntos.toList take n)

	def diferenciasDivididas = (1 to puntos.size) map {i => diferenciaDividida(i)}
}
