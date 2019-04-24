package org.mephys.jubatus

import scala.collection.mutable

/**
  * Created by david on 19/10/2016.
  */
class Interpreter {

  val stack : mutable.Stack[Int] = mutable.Stack()

  var err =  false

  def disp(s: String)  = if(!err) println(s) else err=false
  def dispErr(s: String) = {err=true; println("ERROR: "+ s)}

  def getArgs(n: Int): Array[Int] = {
    val vec: Array[Int]= new Array[Int](n)
    for(i <- 0 until n){
      if(stack.isEmpty) {
        dispErr("stack has not enough objects")
        return null
      }
      vec(n-1-i)=stack.pop
    }
    vec
  }

  def process(array: Array[String]) = {
    val int ="([\\+-]*\\d+)".r
    array.foreach(a => a match {
      case int(b) => stack.push(b.toInt)
      case "dup" => if(stack.isEmpty) dispErr("stack is empty") else stack.push(stack.head)
      case ".p" => if(stack.isEmpty) print("() ") else print(stack.toList.mkString(" <-- ")+" ")
      case "+"  => {
        val x = getArgs(2)
        if(x!=null) stack.push(x(0)+x(1))
      }
      case "*"  => {
        val x = getArgs(2)
        if(x!=null) stack.push(x(0)*x(1))
      }
      case "/"  => {
        val x = getArgs(2)
        if(x!=null) stack.push(x(0)/x(1))
      }
      case "%"  => {
        val x = getArgs(2)
        if(x!=null) stack.push(x(0)%x(1))
      }
      case "-"  => {
        val x = getArgs(2)
        if(x!=null) stack.push(x(0)-x(1))
      }
      case "." => if(stack.isEmpty) dispErr("stack is empty") else print(stack.pop+" ")
      case "" => {}
      case _ => dispErr("operation unknown")
    })
    disp("ok")
  }

}
