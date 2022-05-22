package model.rules;

import model.Dealer;
import model.Player;

/**
 * Creates Win rules.
 */
public interface WinRule {
    public boolean DealerWinner(Player player, Dealer dealer, int maxScore);
}
