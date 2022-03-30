package cs2.adt

import org.junit._
import org.junit.Assert._

class QueueTester {
  var q:Queue[Int] = null

  @Before def init():Unit = {
    q = Queue[Int]()
  }

  @Test def testIsEmpty():Unit = {
    assertTrue(q.isEmpty())
    q.enqueue(1)
    assertFalse(q.isEmpty())
    q.peek()
    assertFalse(q.isEmpty())
    q.dequeue()
    assertTrue(q.isEmpty())
  }

  @Test def testEnqueueDequeuePeek():Unit = {
    q.enqueue(1)
    assertTrue(q.peek() == 1)
    assertTrue(q.dequeue() == 1)
    for(iter <- 1 to 5) {
      for(i <- 4 to 79) {
        q.enqueue(i)
      }
      for(i <- 4 to 79) {
        assertTrue(q.peek() == i)
        assertTrue(q.dequeue() == i)
      }
    }
  }

}