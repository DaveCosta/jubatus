package org.mephys.jubatus

/**
  * Created by david on 19/10/2016.
  */
class Interpreter {

  def process(array: Array[String]) = {
    val int ="(\\d+)".r
    val ops ="([+*])".r
    array.foreach(a => a match {
      case int(b) => println("["+b+"]")
      case ops(b) => println("{"+b+"}")
      case _ => println("ok")
    })
  }

}
