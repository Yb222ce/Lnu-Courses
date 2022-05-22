package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

/**
 * InternationalNewGameStrategy implements NewGameStrategy.
 * 
 * 
 */
class InternationalNewGameStrategy implements NewGameStrategy {
  /**
   * deep clone Player object.
   * 
   * @param deck   deck to deliver player and dealer.
   * @param dealer responsible to take control the game
   * @param player plays the game
   * @return always be true.
   */
  public boolean newGame(Dealer dealer, Player player) {

    dealer.deckToPlayer(player);

    dealer.deckToPlayer(dealer);

    dealer.deckToPlayer(player);

    return true;
  }
}