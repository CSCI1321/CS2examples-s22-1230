package cs2.cardgames

class Deck() {
  private var cards:List[Card] = List() //Nil

  def isEmpty():Boolean = { this.cards.length == 0 }
  def deal():Card = {
    if(cards.length == 0) null
    else {
      val ret =this.cards.head
      this.cards = this.cards.tail
      ret
    }
  }
  def add(magicBunny:Card):Unit = {
    this.cards = magicBunny :: this.cards
  }
  def combine(other:Deck):Unit = { 
    cards = cards ::: other.cards
  }
  def shuffle():Unit = {
    this.cards = scala.util.Random.shuffle(this.cards)
  }
  override def toString():String = cards.mkString(", ")

}

object Deck {
  def apply():Deck = {
    val d = new Deck()
    for(r <- 1 to 13) {
      for(s <- Card.SUITS) {
        d.cards ::= new Card(r,s)
      }
    }
    d
  }
  def empty():Deck = new Deck()

  def main(args:Array[String]):Unit = {
    val theDeck = Deck()
    println(theDeck.cards)
  }

}
