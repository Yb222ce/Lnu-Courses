package controller;

import model.Game;
import model.pauseStuff;
import view.View;
import view.Options;

/**
 * Scenario controller for playing the game.
 */
public class Player implements pauseStuff {

  /**
   * Runs the play use case.
   *
   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    int input = view.getInput();

    if (view.getOption(input) == Options.play) {
      view.resetCardIndex();
      pause(view);
      game.newGame();
    } else if (view.getOption(input) == Options.hit) {
      view.promptMessage();
      game.hit();
    } else if (view.getOption(input) == Options.stand) {
      game.stand();
    }

    return view.getOption(input) != Options.quit;
  }

  /**
   *  Call interface view and make the Game pause.
   *
   * @param view The view to use.
   * 
   */
  public void pause(View view) {
    view.promptMessage();
    view.promptMessage();
  }

}
