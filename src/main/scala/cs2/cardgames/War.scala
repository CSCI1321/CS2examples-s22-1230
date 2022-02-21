package cs2.cardgames

object War {
  def main(args:Array[String]):Unit = {
    val deck = Deck()
    deck.shuffle()
    var p1Hand = Deck.empty()
    var p2Hand = Deck.empty()
    while(!deck.isEmpty()) {
      p1Hand.add(deck.deal())
      p2Hand.add(deck.deal())
    }
    while(!p1Hand.isEmpty() && !p2Hand.isEmpty()) {
      var p1Card = p1Hand.deal()
      var p2Card = p2Hand.deal()
      var thePot = Deck.empty()
      println(p1Card + " vs " + p2Card)
      thePot.add(p1Card)
      thePot.add(p2Card)
      while(p1Card != null && p2Card != null && p1Card == p2Card && !p1Hand.isEmpty() && !p2Hand.isEmpty()) {
        println("WAR!!!")
        //Add the top 3 cards to the pot
        for(i <- 1 to 3) {
          thePot.add(p1Hand.deal())
          thePot.add(p2Hand.deal())
        }
        //Get the next card to be the card in hand
        p1Card = p1Hand.deal()
        p2Card = p2Hand.deal()
        println("The pot contains: " + thePot)
        println("--- " + (if(null == p1Card) "EMPTY" else p1Card) + 
                " vs " + (if(null == p2Card) "EMPTY" else p2Card))
        thePot.add(p1Card)
        thePot.add(p2Card)
      }
      //If no one has run out of cards, we're going to keep going
      if(p1Card != null && p2Card != null) {
        if(p1Card > p2Card) {
          p1Hand.combine(thePot)
          p1Hand.shuffle()
        } else if(p2Card > p1Card) {
          p2Hand.combine(thePot)
          p2Hand.shuffle()
        }
      }
    }
    if(p1Hand.isEmpty()) println("Player 2 wins!")
    else println("Player 1 wins!")
  }
}
