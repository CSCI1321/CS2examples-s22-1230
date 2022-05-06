package cs2.parallel

import io.StdIn._

object SimpleThreads {
  
  def countDownGetName():Unit = {
    val thread = new Thread {
      override def run():Unit = {
        //The counting thread
        for(i <- 1 to 5) {
          println(i)
          Thread.sleep(1000)
        }
        println("Times up")
        sys.exit(0)
      }
    }
    thread.start

    //Getting the name thread
    println("Enter your name:")
    val name = readLine()
    thread.stop
    println("Hello, " + name)
  }

  class Lock
  val lock = new Lock()

  def countToABillion():Unit = {
    var ctr = 0

    val threads = Array.fill(10)(new Thread {
      override def run():Unit = {
        for(i <- 1 to 1000000000/10) {
          lock.synchronized {
            ctr += 1
          }
        }
      }
    })
    for(t <- threads) { t.start() }
    threads.foreach(_.join)
    
    println(ctr)
  }


  def main(args:Array[String]):Unit = {
    //countDownGetName()
    countToABillion()
  }
}