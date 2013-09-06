package ar.edu.utn.superior.interpolatron

import org.scalatest._
import ar.edu.utn.superior.interpolatron

class InterpolatronSuite extends FunSuite with OneInstancePerTest {
  
  val interpolatron = new Interpolatron
  
  test("3 valores probados en clase") {
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
}