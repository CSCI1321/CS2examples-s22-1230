package cs2.parallel

class TimeLogger {
  private var start = System.nanoTime()
  def reset():Unit = { start = System.nanoTime() }
  def logTime():Unit = {
    println( (System.nanoTime() - start)/1e9 + " seconds" )
  }
}

object FactorialRuntimes {
  def factRecur(n:BigInt):BigInt = {
    if(n <= 1) 1
    else n * factRecur(n-1)
  }

  def factFor(n:BigInt):BigInt = {
    var product:BigInt = 1
    for(x <- BigInt(1) to n) {
      product *= x
    }
    product
  }
  def factParFor(n:BigInt):BigInt = {
    var product:BigInt = 1
    for(x <- (BigInt(1) to n).par) {
      product *= x
    }
    product
  }

  def factCollect(n:BigInt):BigInt = {
    (BigInt(1) to n).reduce(_*_)
  }

  def factParCollect(n:BigInt):BigInt = {
    (BigInt(1) to n).par.reduce(_*_)
  }

  import java.util.concurrent._
  def factExecutor(n:BigInt, k:Int):BigInt = {
    val service = Executors.newCachedThreadPool()
    val tasks:Array[Future[BigInt]] = Array.tabulate(k)((idx:Int) => {
      service.submit(new Callable[BigInt] {
        override def call():BigInt = {
          (BigInt(idx+1) to n by k).product
        }
      })
    })
    val ret = tasks.map(_.get).product
    service.shutdown()
    ret
  }

  def main(args:Array[String]):Unit = {
    val num = 10
    val logger = new TimeLogger

    logger.reset()
    logger.logTime()

    logger.reset()
    //factRecur(num)
    logger.logTime()
    
    logger.reset()
    println(factFor(num))
    logger.logTime()
    /*
    logger.reset()
    factCollect(num)
    logger.logTime()
    */

    logger.reset()
    println(factParFor(num))
    logger.logTime()

    logger.reset()
    println(factParCollect(num))
    logger.logTime()

    /*
    for(i <- 2 to 60 by 2) {
      println(i)
      logger.reset()
      factExecutor(num, i)
      logger.logTime()
    }*/
  }
}