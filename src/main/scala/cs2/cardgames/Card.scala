package cs2.cardgames

class Card(r:Int, s:Char) {
  val rank:Int = if(r > 0 && r < 14) r else 1
  val suit:Char = if(s == Card.HEART || s == Card.DIAMOND ||
                     s == Card.SPADE || s == Card.CLUB) s else Card.SPADE
  override def toString():String = {
    var res = rank match {
      case 1 => "Ace"
      case 11 => "Jack"
      case 12 => "Queen"
      case 13 => "King"
      case x => x.toString
    }
    res += " of "
    res += (if(suit == Card.HEART) "\u2665 "
            else if (suit == Card.DIAMOND) "\u2662 "
            else if (suit == Card.SPADE) "\u2664 "
            else if (suit == Card.CLUB) "\u2663 "
            else "ERROR")
    res
  }

  def < (other:Card):Boolean = { this.rank < other.rank }
  def > (other:Card):Boolean = { this.rank > other.rank }
  def == (other:Card):Boolean = { this.rank == other.rank }

  def >= (other:Card):Boolean = { this.rank >= other.rank }
  def <= (other:Card):Boolean = { this.rank <= other.rank }

  def isRed():Boolean = { 
    suit == Card.HEART || suit == Card.DIAMOND
  }
  def isBlack():Boolean = !isRed

}

object Card {
  val HEART = 'H'
  val DIAMOND = 'D'
  val SPADE = 'S'
  val CLUB = 'C'
  val SUITS = Array(HEART,DIAMOND,SPADE,CLUB)

  def apply(r:Int, s:Char):Card = new Card(r, s)
  def apply():Card = new Card(1, SPADE)

  def main(args:Array[String]):Unit = {
    val c = new Card(12, CLUB)
    val d = new Card(12, CLUB)
    println(c + "\t" + d)
    println(c < d)
    println(c > d)
    println(c == d)
  }
}


