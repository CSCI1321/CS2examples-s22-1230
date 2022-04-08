package cs2.adt

abstract class Seq[A] extends Iterable[A] {
  def get(idx:Int):A
  def set(idx:Int, elem:A)
  def insert(idx:Int, elem:A)
  def remove(idx:Int)
  def length():Int
  def iterator:Iterator[A]
}

object Seq {
  def apply[A]():Seq[A] = {
    new LinkedSeq[A]()
  }

  def main(args:Array[String]):Unit = {
    val s = Seq[Char]()
    s.insert(0, 'A')
    s.insert(0, 'B')
    s.insert(0, 'C')
    for(i <- 0 until s.length()) {
      println(s.get(i))
    }

    var it = s.iterator
    while(it.hasNext) {
      println(it.next)
    }

    it = s.iterator
    it.foreach(println)

    for(x <- s) { println(x) }

  }

}

