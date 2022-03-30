package cs2.adt

import org.junit._
import org.junit.Assert._

class StackTester {
  var s:Stack[Int] = Stack[Int]()

  @Before def init():Unit = {
    s = Stack[Int]()
  }

  @Test def checkNotEmptyAfterPush():Unit = {
    s.push(1)
    assertTrue(!s.isEmpty())
  }

  @Test def checkInitialEmpty():Unit = {
    assertTrue(s.isEmpty())
  }

  @Test def checkManyPushPop():Unit = {
    for(i <- 1 to 50) {
      s.push(i)
    }
    assertTrue(!s.isEmpty())
    for(i <- 50 to 1 by -1) {
      assertTrue(s.peek == i)
      assertTrue(s.pop == i)
    }
    assertTrue(s.isEmpty())
  }

}


