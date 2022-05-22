package model.rules;

import model.Card;
import model.Player;

/**
 * implements HitStrategy.
 */
public class Soft17 implements HitStrategy {
  private static final int hitLimit = 17;
  protected final int maxScore = 21;

  /**
   * deep clone Player object.
   *
   * @param player target player.
   * @return new cloned player.
   */
  public Player clonePlayer(Player player) {
    Player newPlayer = new Player();
    player.showHand();
    for (Card.Mutable c : player.getHandCard()) {
      newPlayer.dealCard(c);
    }
    return newPlayer;
  }

  /**
   * tell whether the dealer needs to hit again.
   * 
   * @param player dealer for input.
   * @return true if dealer needs to hit again.
   */
  public boolean doHit(Player dealer) {

    if (dealer.calcScore() < hitLimit) {
      return true;
    } else if (dealer.calcScore() == hitLimit) {
      Player agent = clonePlayer(dealer);
      Card.Mutable c = new Card.Mutable(Card.Color.Hearts, Card.Value.King);
      agent.dealCard(c);
      if (agent.calcScore() == hitLimit) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
