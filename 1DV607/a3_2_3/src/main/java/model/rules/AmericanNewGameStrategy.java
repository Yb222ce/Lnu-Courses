package model.rules;

import model.Dealer;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Dealer dealer, Player player) {

    dealer.deckToPlayer(player);

    dealer.deckToPlayer(dealer);
 
    dealer.deckToPlayer(player);

    dealer.deckToPlayer(dealer);

    return true;
  }
}