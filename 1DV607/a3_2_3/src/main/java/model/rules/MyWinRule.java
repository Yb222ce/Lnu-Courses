package model.rules;

import model.Dealer;
import model.Player;

public class MyWinRule implements WinRule {
  public boolean DealerWinner(Player player, Dealer dealer, int maxScore) {
    if (player.calcScore() > maxScore) {
      return true;
    } else if (dealer.calcScore() > maxScore) {
      return false;
    }
    return dealer.calcScore() > player.calcScore();
  }
}
