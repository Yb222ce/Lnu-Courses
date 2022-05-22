package model;

import java.util.List;

import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.WinRule;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 * 
 */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinRule winRule;

  /**
   * Initializing constructor.
   *
   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesFactory rulesFactory) {

    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winRule = rulesFactory.getWinRule();
  }

  /**
   * Starts a new game if the game is not currently under way.
   *
   * @param player The player to play agains.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.
   *
   * @param player The player to give a card to.
   * @return true if the player could get a new card, false otherwise.
   */

  public boolean hit(Player player) {

    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      deckToPlayer(player);
      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.
   *
   * @param player The player to check agains.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    return winRule.DealerWinner(player, this, maxScore);
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.
   *
   * @return True if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
      return true;
    }
    return false;
  }

  /**
   * The player has choosen to take no more cards, it is the dealers turn.
   *
   * @return True if the deck is not null.
   */
  public boolean stand() {
    if (deck != null) {
      showHand();
      while (hitRule.doHit(this) == true) {
        Card.Mutable c = deck.getCard();
        c.show(true);
        dealCard(c);
        System.out.println("Value: " + c.getValue() + " Color: " + c.getColor());
        System.out.println("Score: " + this.calcScore() + "\n");
      }
      return true;
    }

    return false;
  }



  /**
   * Gets the first card in the deck. The card is removed from the deck.
   *
   * @param player take a card from the deck and add it to a player
   */
  public void deckToPlayer(Player player) {
    Card.Mutable c = deck.getCard();
    c.show(true);
    player.dealCard(c);
  }

}