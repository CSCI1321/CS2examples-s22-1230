package cs2.adt

abstract class Seq[A] {
  def get(idx:Int):A
  def set(idx:Int, elem:A)
  def insert(idx:Int, elem:A)
  def remove(idx:Int)
  def length():Int
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
  }

}

