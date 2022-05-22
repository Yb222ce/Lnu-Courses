package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class SimpleTest {

@Test
public void testSoft17() 
{
    /* Create Some cards */
    Card.Mutable c1 = new Card.Mutable(Card.Color.Spades, Card.Value.Ace);
    Card.Mutable c2 = new Card.Mutable(Card.Color.Spades, Card.Value.Two);
    Card.Mutable c3 = new Card.Mutable(Card.Color.Spades, Card.Value.Five);

    Dealer dealer = new Dealer(new model.rules.RulesFactory());
    // dealer.newGame(player);
    dealer.dealCard(c1);
    dealer.dealCard(c2);
    dealer.dealCard(c3);
    for (Card card : dealer.getHand()) {
        System.out.println("" + card.getValue() + " of " + card.getColor());
    }
    assertTrue(17 >= dealer.calcScore());
} 
  
}
