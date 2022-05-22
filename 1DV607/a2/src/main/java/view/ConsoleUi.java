package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Boat;
import model.Boat.Type;
import model.Member;
import model.MemberGroup;

/**
 * ConsoleUI implments CommandUI and it has only one attribute: members.
 */
public class ConsoleUi implements CommandUi {
  /**
   * Enumeration for boat option when you modify boat info.
   */
  public enum BoatOption {
    changeBoatType, changeBoatDate, changeBoatName
  }

  /**
   * Enumeration for member option when you modify member info.
   */
  public enum MemberOption {
    changeMemberId, changeMemberName, changeMemberPersonalNumber
  }

  /**
   * Call to return input character.
   *
   * @return return the user entered character.
   */
  public int getInputChar() {
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
   * By default, BufferReader will use a buffer of 8 KB, assuming the file is.
   * encoded as UTF-8.
   *
   * @return get the user input as string.
   */
  @Override
  public String getKeyboard() {

    BufferedReader reader = null;

    reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

    try {
      return reader.readLine();
    } catch (IOException e) {
      return "Damn";
    }

  }

  /**
   * Call to show general prompt.
   */

  public void showGeneralPrompt() {
    System.out.println("\n");
    System.out.println("Press 0 to exit the game");
    System.out.println("Press 1 to add Member");
    System.out.println("Press 2 to remove a member");
    System.out.println("Press 3 to show all boats the member has");
    System.out.println("Press 4 to show all members name in the group");
    System.out.println("Press 5 to show all info about this member");
    System.out.println("Press 6 to add a boat to a existing member");
    System.out.println("Press 7 to remove a boat from a existing member");
    System.out.println("Press 8 to change info from a existing member");
    System.out.println("Press 9 to change boat info from a existing member");
    System.out.print("Please enter a number(0-9): ");
  }

  /**
   * Call to get the type of the boat.
   *
   * @return return the type to the controller.
   */
  public Type getBoatTypePrompt() throws IOException {
    System.out.println("Press 's' for Sailboat");
    System.out.println("Press 'm' for Motorsailer");
    System.out.println("Press 'c' for Canoe");
    System.out.print("Choose a type: ");

    int c = getInputChar();
    Type type = null;
    if (c == 's') {
      type = Type.Sailboat;
    } else if (c == 'm') {
      type = Type.Motorsailer;
    } else if (c == 'c') {
      type = Type.Canoe;
    } else {
      System.out.println("Please choose a correct type from types mentioned above");
    }
    getKeyboard(); /* Eat '\n' */
    return type;
  }

  /**
   * Call to get the option number when changing Member info.
   *
   * @return change member option number to the controller.
   */
  public int getOptionsMember() {
    System.out.println("Press 1 for change id");
    System.out.println("Press 2 to change name");
    System.out.println("Press 3 to change personal Number");
    System.out.print("Choose an option from above: ");
    int optionNum = -1;

    optionNum = Integer.parseInt(getKeyboard());

    return optionNum;
  }

  /**
   * Call to get the option number when changing boat info.
   *
   * @return change boat option number to the controller.
   */
  public int getOptionsBoat() {
    System.out.println("Press 1 for change type");
    System.out.println("Press 2 to change registration date");
    System.out.println("Press 3 to change boat name");
    System.out.print("Choose an option from above: ");
    int optionNum = -1;

    optionNum = Integer.parseInt(getKeyboard());

    return optionNum;
  }

  /**
   * Call to get the option number when changing Member info.
   *
   * @return prompt the user to enter member index.
   */
  public int getMemberIndex() {
    System.out.print("Enter the index number of your member: ");
    int index = Integer.parseInt(getKeyboard());
    return index;
  }

  /**
   * Call to remove a member from registry.
   *
   * @return return the boat index number to the Controller
   */
  public int getBoatIndex() {
    System.out.print("Enter the index number of your boat: ");
    int indexBoat = Integer.parseInt(getKeyboard());
    return indexBoat;
  }

  /**
   * Call to remove a member from registry.
   *
   * @param num the member list registry data.
   * @return return the choice option to the Controller
   */
  public Choices getChoices(int num) {
    // int num = Integer.parseInt(input);
    switch (num) {
      case 0:
        return Choices.Exit;
      case 1:
        return Choices.addMember;
      case 2:
        return Choices.removeMember;
      case 3:
        return Choices.showMemberBoat;
      case 4:
        return Choices.showAllMember;
      case 5:
        return Choices.showMemberInfo;
      case 6:
        return Choices.addBoat;
      case 7:
        return Choices.removeBoat;
      case 8:
        return Choices.changeMemberInfo;
      case 9:
        return Choices.ChangeBoatInfo;
      default:
        System.out.println("Please enter a correct code number!");
        return null;
    }

  }

  /**
   * Call to get the option number when changing Boat info.
   *
   * @param num boatOption number.
   * @return boat option number to the controller.
   */
  public BoatOption modifyBoatOptions(int num) {
    switch (num) {
      case 1:
        return BoatOption.changeBoatType;
      case 2:
        return BoatOption.changeBoatDate;
      case 3:
        return BoatOption.changeBoatName;
      default:
        System.out.println("Please choose a correct code to modify the Boat!");
        return null;
    }
  }


  /**
   * Call to get the option number when changing Member info.
   *
   * @param num memberOption number.
   * @return member option number to the controller.
   */
  public MemberOption modifyMemberOptions(int num) {
    switch (num) {
      case 1:
        return MemberOption.changeMemberId;
      case 2:
        return MemberOption.changeMemberName;
      case 3:
        return MemberOption.changeMemberPersonalNumber;
      default:
        System.out.println("Please choose a correct code to modify the Member!");
        return null;
    }
  }

  /**
   * Call to show verbose info about the Member.
   *
   * @param index index of this member.
   * @param members member registry group.
   */
  public void showMemberInfo(int index, MemberGroup members) {
    Member m = members.getaMember(index);
    System.out.printf("%12s%12s%20s%15s%n", "id", "Name", "PersonalNumber", "NumberofBoats");
    System.out.printf("%12s%12s%20s%15d%n", m.getId(), m.getName(), m.getPersonalNumber(), m.getBoatNumber());
  }

  /**
   * Call to show verbose boat info about this member.
   *
   * @param index index of the Member.
   * @param members member registry group.
   */
  public void showMemberBoat(int index, MemberGroup members) {
    if (index > members.numberOfMember() - 1) {
      System.out.println("this member index is out of range!");
    } else {
      if (members.getaMember(index).getBoats().size() == 0) {
        System.out.println("This member doesn't own any boats yet!");
        return;
      }
      System.out.println("Member name: " + members.getaMember(index).getName());
      System.out.printf("%10s%15s%20s%n", "boatName", "boatType", "boatRegistration");
      for (Boat b : members.getaMember(index).getBoats()) {
        DateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%10s%15s%20s%n", b.getName(), b.getType(), parser.format(b.getRegistration()));
      }
    }
  }

  /**
   * Call to display compact list of registry data.
   *
   * @param members member registry group.
   */
  public void displayCompactInfo(MemberGroup members) {
    int i = 0;
    System.out.printf("%12s%12s%20s%15s%n", "id", "Name", "PersonalNumber", "NumberofBoats");
    for (Member m : members.getMembers()) {
      System.out.printf("%2d.", i++);
      System.out.printf("%9s%12s%20s%15d%n", m.getId(), m.getName(), m.getPersonalNumber(), m.getBoatNumber());
    }
  }

  /**
   * Call to show prompt when removing Boat of an existi Member.
   *
   * @param n true if the Boat exists.
   */
  public void removeBoatPrompt(boolean n) {
    if (n) {
      System.out.println("Boat has been successfully removed");
    } else {
      System.out.println("This index number is out of range!");
    }
  }

  /**
   * Call to show prompt when removing a member.
   *
   * @param n true if the member exists.
   */
  public void removeMemberPrompt(boolean n) {
    if (n) {
      System.out.println("This member has been successfully removed from the group");
    } else {
      System.out.println("This index is out of range in out member list!");
    }
  }

  /**
   * Call to return a new Boat.
   *
   * @return a new boat Object.
   */
  public Boat createBoat() {
    Type type = null;
    try {
      type = getBoatTypePrompt();
    } catch (IOException e1) {
      e1.printStackTrace();
    } /* get the type from cmdUI */
    System.out.print("Please enter the date in format dd/MM/yyyy: ");
    String dateString = getKeyboard();
    Date date = new Date();
    try {
      date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Boat boat = new Boat(type, date);
    System.out.print("Please enter the name of your boat: ");
    String boatName = getKeyboard();
    boat.setName(boatName);
    return boat;
  }

  /**
   * Call to return Boat.
   *
   * @param m member registry data.
   * @return return a member from the registry.
   */
  public Member getMember(MemberGroup m) {
    System.out.print("Enter the index number of your member: ");
    int memberNumber = Integer.parseInt(getKeyboard());
    Member memberBoat = m.getaMember(memberNumber);
    return memberBoat;
  }

  /**
   * Call to return a new member.
   *
   * @return a new Member Object.
   */
  public Member createMember() {
    System.out.print("Enter the id: ");
    ;
    String id = getKeyboard();

    System.out.print("Enter the name of the member: ");
    String name = getKeyboard();

    System.out.print("Enter the personal number: ");
    String personalNumber = getKeyboard();

    /* Create a new member object */
    Member member = new Member(id, name, personalNumber);
    return member;
  }

  /**
   * Call to show prompt message when the member does not exists.
   *
   */
  public void memberNotExist() {
    System.out.println("This member dosen't exist");
  }

  /**
   * Call to show prompt message when the boat does not exists.
   *
   */
  public void boatNotExist() {
    System.out.println("This boat dosen't exist");
  }

  /**
   * Call to create member ID.
   *
   * @return get ID as String.
   */
  public String createId() {
    System.out.print("Please enter your correct id: ");
    String id = getKeyboard();
    return id;
  }

  /**
   * Call to create member name.
   *
   * @return get name as String.
   */
  public String createName() {
    System.out.print("Please enter your correct name: ");
    String name = getKeyboard();
    return name;
  }

  /**
   * Call to create personal number.
   *
   * @return personal number as string.
   */
  public String createPersonalNumber() {
    System.out.print("Please enter your correct personal Number: ");
    String personalNumber = getKeyboard();
    return personalNumber;
  }

  /**
   * Call to create date of the boat.
   *
   * @return get boat date as String.
   */
  public String createBoatDate() {
    System.out.print("Please enter the date in format dd/MM/yyyy: ");
    String dateString = getKeyboard();
    return dateString;
  }

  /**
   * Call to create Boat Name.
   *
   * @return get boat Name as String.
   */
  public String createBoatName() {
    System.out.print("Please enter the name of your boat: ");
    String boatName = getKeyboard();
    return boatName;
  }

  /**
   * Call to display prompt when the option does not exist.
   *
   */
  public void optionDoesNotExit() {
    System.out.println("This option doesn't exist");
  }

  /**
   * Call to display prompt when the boat was successfully added.
   *
   */
  public void boatAddedMessage() {
    System.out.println("This boat has been successfully added!");
  }

  /**
   * Call to display prompt when the member was successfully added.
   *
   * @param n true means that the memberID is unique in registry.
   */
  public void memberAddedMessage(boolean n) {
    if (n) {
      System.out.println("The member has been successfully added to the registry");
    } else {
      System.out.println("This member ID has already existed!");
    }
  }

  /**
   * Call to prompt the user to press enter to continue the Game.
   *
   */
  public void pressAnyKeyToContinue() {
    System.out.println("Press Enter key to continue...");
    try {
      System.in.read();
    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
