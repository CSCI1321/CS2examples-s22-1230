package cs2.cardgames

class Card(r:Int, s:Char) {
  val rank:Int = if(r > 0 && r < 14) r else 1
  val suit:Char = if(s == Card.HEART || s == Card.DIAMOND ||
                     s == Card.SPADE || s == Card.CLUB) s else Card.SPADE
  override def toString():String = {
    rank.toString + " of " + suit
  }

  def < (other:Card):Boolean = { this.rank < other.rank }
  def > (other:Card):Boolean = { this.rank > other.rank }
  def == (other:Card):Boolean = { this.rank == other.rank }
}

object Card {
  val HEART = 'H'
  val DIAMOND = 'D'
  val SPADE = 'S'
  val CLUB = 'C'
  val SUITS = Array(HEART,DIAMOND,SPADE,CLUB)

  def main(args:Array[String]):Unit = {
    val c = new Card(12, CLUB)
    val d = new Card(12, CLUB)
    println(c + "\t" + d)
    println(c < d)
    println(c > d)
    println(c == d)
  }
}


