package org.mephys.tools

import java.io.EOFException
import java.lang.StringIndexOutOfBoundsException

/**
  * Created by david on 19/10/2016.
  */

object konsoleCode extends Enumeration {
  type KonsoleCode = Value
  val EXIT, RUNNING, INIT = Value
}

class Konsole(promt: String) {

  import org.mephys.tools.konsoleCode._

  var status: KonsoleCode = INIT
  val stdin = scala.io.StdIn
  var cmd = new StringBuilder()

  override def toString: String = cmd.toString

  def stat = status

  def close = {
    status = EXIT
  }

  def get(): String = {

    cmd.clear()
    print(promt + " ")
    status = RUNNING
    var flag = true
    while (flag) {

      var c: Char=0

      try {
        c = stdin.readChar()
      } catch {
        case ex: EOFException  => c = 1
        case ex:StringIndexOutOfBoundsException => c = 0
      }

      println(c.toInt)

      c match {
        case 0  => { flag = false}
        case 1 =>  {status = EXIT; flag = false}
        case '\u0004'=> {
          status = EXIT; flag = false
        }
        case '\n' | '\r' => flag = false
        case _ =>  cmd.append(c)
      }

    }

    cmd.toString
  }

}

