package ar.edu.utn.superior.interpolatron

import org.scalatest._
import ar.edu.utn.superior.interpolatron
import scala.collection.mutable.SortedSet

class InterpolatronSuite extends FunSuite with OneInstancePerTest {
  
  val interpolatron = new Interpolatron
  
  test("Valores probados en clase") {
    interpolatron agregar (1, 2) agregar (2, 5) agregar (3, 9)
    assert(interpolatron.diferenciasDivididas === List(2, 3, 0.5))
  }
  
  test("Conjunto vacio de puntos") {
    intercept[NingunPuntoIngresadoException] {
      interpolatron.diferenciasDivididas
    }
  }
  
  test("Puntos que no forman una funcion") {
    interpolatron agregar (2, 3)
    intercept[PuntoDuplicadoException] {
      interpolatron agregar (2, 4)
    }
  }
    
  test("Ordenar puntos por abscisa de menor a mayor") {
    interpolatron agregar (5, 1) agregar (4, 1) agregar (3, 1)
    assert(interpolatron.abscisas.toList === List(3, 4, 5))
  }
}