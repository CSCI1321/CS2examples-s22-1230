package cs2.hello

import io.StdIn._

object HelloWorld {
  def main(args:Array[String]):Unit = {
    println("Hello world!")
    val name = readLine("Enter your name: ")
    println("Hello, " + name + "!")
  }
}





