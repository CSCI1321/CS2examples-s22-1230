package cs2.algorithms

import scala.collection.mutable.Buffer
import io.StdIn._

object UndoText {
  def main(args:Array[String]):Unit = {

    var history = Buffer[String]()
    var line = readLine()
    while(line != "QUIT") {
      if(line == "UNDO") {
        history.remove(history.length-1)
      } else {
        history.append(line)
      }
      println(history.mkString(" "))
      line = readLine()
    }

  }
}