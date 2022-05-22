package view;

import java.io.IOException;
import model.Boat;
import model.Boat.Type;
import model.Member;
import model.MemberGroup;
import view.ConsoleUi.BoatOption;
import view.ConsoleUi.MemberOption;

/**
 * Interface CommandUI.
 */
public interface CommandUi {
  /**
   * get Choice from the User.
   */
  public Choices getChoices(int num);

  public void showGeneralPrompt();

  public String getKeyboard();

  public Type getBoatTypePrompt() throws IOException;

  public int getOptionsMember();

  public int getOptionsBoat();

  public int getMemberIndex();

  public int getBoatIndex();

  public void showMemberInfo(int index, MemberGroup members);

  public void showMemberBoat(int index, MemberGroup members);

  public void displayCompactInfo(MemberGroup members);

  public BoatOption modifyBoatOptions(int num);

  public MemberOption modifyMemberOptions(int num);

  public void removeBoatPrompt(boolean n);

  public void removeMemberPrompt(boolean n);

  public Boat createBoat();

  public Member getMember(MemberGroup m);

  public Member createMember();

  public void memberNotExist();

  public void boatNotExist();

  public String createId();

  public String createName();

  public String createPersonalNumber();

  public String createBoatDate();

  public String createBoatName();

  public void optionDoesNotExit();

  public void boatAddedMessage();

  public void memberAddedMessage(boolean n);

  public void pressAnyKeyToContinue();
}
