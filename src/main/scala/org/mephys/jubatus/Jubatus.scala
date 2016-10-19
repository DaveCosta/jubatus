package org.mephys.jubatus

import org.mephys.tools.Konsole
import org.mephys.tools.konsoleCode._

object Jubatus {

  def main(args: Array[String]): Unit = {

    var running = true

    val konsole = new Konsole("jubatus>")

    while (running) {

      while (konsole.status != EXIT) {
        konsole.get match {
          case "q" => konsole.close
          case _ => ;
        }

      }

    }
  }

}