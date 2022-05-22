package view;

import java.util.concurrent.TimeUnit;

/**
 * Implements an english console view.
 */
public class EnglishView implements View {

  private int cardIndex = 0;

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
   * Returns pressed characters from the keyboard.
   * 
   * @return the pressed character.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  /**
   * Returns pressed characters from the keyboard.
   * 
   * @param input is a ASCII number
   * @return return Option.
   */
  public Options getOption(int input) {
    if (input == 'p') {
      return Options.play;
    } else if (input == 'h') {
      return Options.hit;
    } else if (input == 's') {
      return Options.stand;
    } else if (input == 'q') {
      return Options.quit;
    }
    return Options.errorCommamd;
  }

  /**
   * output Dealer and Player cards according to the order.
   * 
   * @param c is character
   */
  public void message(char c) {
    if (c == 'D') {
      System.out.print("Dealer: ");
    } else if (c == 'P') {
      System.out.print("Player: ");
    } else {
      System.out.println("Wrong Character, please choose D/P");
    }
    for (int i = 1; i <= cardIndex; i++) {
      if (i == cardIndex)
        System.out.println("c" + i);
      else
        System.out.print("c" + i + ", ");
    }
    if (cardIndex == 0) {
      System.out.println();
    }
  }

  /**
   * delay n seconds.
   * 
   * @param n is a long number
   */
  public void delaySeconds(long n) {
    /* Code for delay n seconds */
    System.out.println("*pause for " + n + " seconds*");
    try {
      TimeUnit.SECONDS.sleep(n);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }
  }

  /**
   * Show promptMessage with the delay.
   * 
   */
  public void promptMessage() {
    /* Player Turn */
    message('D');
    cardIndex++;
    message('P');
    delaySeconds(2);

    /* Dealer Turn */
    message('D');
    message('P');
    delaySeconds(2);

  }

  /**
   * reset cardIndex to 0.
   * 
   */
  public void resetCardIndex() {
    cardIndex = 0;
  }

  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.
   * 
   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }

  }
}
