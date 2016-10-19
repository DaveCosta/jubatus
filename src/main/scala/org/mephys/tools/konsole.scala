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

  def getCmds : Array[String] = cmd.split(' ')

  def get(): String = {

    cmd.clear()
    print(promt + " ")
    status = RUNNING

    val line = scala.io.StdIn.readLine();

    if(line==null) {
      status = EXIT
      return ""
    }   else line foreach(
        c =>  c match {
        case 0  => ;
        case _ =>  cmd.append(c)
      })
    cmd.toString
  }

}

