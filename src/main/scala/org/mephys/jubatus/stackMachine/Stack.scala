package org.mephys.jubatus.stackMachine

/**
  * Created by david on 20/10/2016.
  */
class Stack[T](defaut: T) {

  val value : T  = defaut
  var stack : Stack[T] = null

  def push(x: T) = {
    val that = new Stack[T](x)
    this.stack=that
  }
}
