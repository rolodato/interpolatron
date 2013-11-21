package ar.edu.utn.superior.interpolatron

import ar.edu.utn.superior.interpolatron._

object inter {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val punto0 = new Punto(1, 2)                    //> punto0  : ar.edu.utn.superior.interpolatron.Punto = ar.edu.utn.superior.inte
                                                  //| rpolatron.Punto@f267434
  val punto1 = new Punto(2, 5)                    //> punto1  : ar.edu.utn.superior.interpolatron.Punto = ar.edu.utn.superior.inte
                                                  //| rpolatron.Punto@259709b1
  val punto2 = new Punto(3, 9)                    //> punto2  : ar.edu.utn.superior.interpolatron.Punto = ar.edu.utn.superior.inte
                                                  //| rpolatron.Punto@5efd56be

  val interpolatron: Interpolatron = new Interpolatron
                                                  //> interpolatron  : ar.edu.utn.superior.interpolatron.Interpolatron = ar.edu.ut
                                                  //| n.superior.interpolatron.Interpolatron@51a5aa86

  interpolatron.puntos = List(punto0, punto1, punto2)
  
  interpolatron.armarPolinomios                   //> res0: String = P(x) = 2.0 + Vector(3.0.(x-1.0) + , 0.5.(x-2.0) + )
}