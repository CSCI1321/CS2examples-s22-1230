package cs2.parallel

object Deadlocks {
  class Lock

  val lock1 = new Lock
  val lock2 = new Lock

  def funcA():Unit = {
    lock1.synchronized({
      println("A has 1")
      lock2.synchronized({
        println("A has 2")
      })
    })
  }
  def funcB():Unit = {
    lock2.synchronized({
      println("B has 2")
      lock1.synchronized({
        println("B has 1")
      })
    })
  }

  def tryToDeadlock():Unit = {
    val athreads = Array.fill(5)(new Thread {
      override def run():Unit = funcA
    })
    val bthreads = Array.fill(5)(new Thread {
      override def run():Unit = funcB
    })
    athreads.foreach(_.start)
    Thread.sleep(1)
    bthreads.foreach(_.start)
  }

  def simpleWaitNotify():Unit = {
    var turn = -1
    val threads:Array[Thread] = Array.tabulate(10)((idx:Int) => new Thread {
      override def run():Unit = {
        println("Thread " + idx + " has started")

        lock1.synchronized({
          while(turn != idx) lock1.wait

          Thread.sleep(1000)
          println("Work is done by thread " + idx)

          turn += 1
          lock1.notifyAll
        })
      }
    })
    threads.foreach(_.start)
    Thread.sleep(50)
    turn = 0
    lock1.synchronized { lock1.notifyAll }
    threads.foreach(_.join)
  }

  def main(args:Array[String]):Unit = {
    //tryToDeadlock()
    simpleWaitNotify()
  }
}