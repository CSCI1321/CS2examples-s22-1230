package cs2.hello

import org.junit._
import org.junit.Assert._

class HelloWorldTester {
  @Before def init():Unit = { println("Before Hello!") }
  @Test def hello():Unit = { println("Hello test!") }
}