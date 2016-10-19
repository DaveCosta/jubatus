package org.mephys.jubatus

import org.mephys.tools.Konsole
import org.mephys.tools.konsoleCode._

object Jubatus {

  def version = "0.1 - 19 October 2016"

  def main(args: Array[String]): Unit = {

    var running = true

    val konsole = new Konsole("jubatus>")

    val interpreter = new Interpreter()

      println("Jubatus Interpreter version: " + version)
      println();

      while (konsole.status != EXIT) {
        konsole.get match {
          case "q" => konsole.close
          case _ => interpreter.process(konsole.getCmds)
        }

      }

    }


}