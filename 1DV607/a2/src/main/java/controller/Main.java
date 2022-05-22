package controller;

import model.HardCodeData;
import model.MemberGroup;
import view.CommandUi;
import view.ConsoleUi;

/**
 * Gets a message from the model and tells the view to show it.
 */
public class Main {
  /**
   * The model to get message from. The view used to show the message.
   */
  public static void main(String[] args) throws Exception {
    /* data class */
    HardCodeData data = new HardCodeData();
    /* command UI */
    CommandUi console = new ConsoleUi();
    /* registration info */
    MemberGroup members = data.getMembers();
    System.out.println("First Member Name: " + members.getaMember(0).getName());

    MainController control = new MainController(console, members);
    control.startGame();
  }

}
