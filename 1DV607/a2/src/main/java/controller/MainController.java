package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Boat;
import model.Boat.Type;
import model.Member;
import model.MemberGroup;
import view.Choices;
import view.CommandUi;
import view.ConsoleUi.BoatOption;
import view.ConsoleUi.MemberOption;

/**
 * The main Controller.
 * 
 */
public class MainController {
  CommandUi console;
  MemberGroup members;

  /**
   * construct and initialise the MainController.
   *
   * @param console display prompt and send command to model.
   * @param members contain info of registry.
   */
  public MainController(CommandUi console, MemberGroup members) {
    this.console = console;
    this.members = members;
  }

  /**
   * Initialise and start the game.
   *
   */
  public void startGame() throws IOException {
    int num = -1;
    do {
      console.showGeneralPrompt();
      num = Integer.parseInt(console.getKeyboard());
      if (num == 0) {
        break;
      }
      getPrompt(console.getChoices(num));
      console.pressAnyKeyToContinue();
      console.getKeyboard();
    } while (num != 0);

  }

  /**
   * add a member to the registry.
   *
   * @param m the member registry data.
   */
  public void addMember(MemberGroup m) throws IOException {

    Member member = console.createMember();
    boolean n = members.addMember(member);
    console.memberAddedMessage(n);
  }

  /**
   * remove a member from registry info.
   *
   * @param m the member registry data.
   */

  public void removeMember(MemberGroup m) throws NumberFormatException, IOException {
    int index = console.getMemberIndex();
    boolean n = members.removeMember(index);
    console.removeMemberPrompt(n);
  }

  /**
   * Show all boats of a member.
   *
   * @param m the member registry data.
   */
  public void showMemberBoat(MemberGroup m) {

    try {
      int index = console.getMemberIndex();
      console.showMemberBoat(index, m);
    } catch (NullPointerException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * Display all Member info to the User.
   *
   * @param m the member registry data.
   */
  public void showAllMember(MemberGroup m) {
    console.displayCompactInfo(m);
  }

  /**
   * Display this Member info to the User.
   *
   * @param m the member registry data.
   */
  public void showMemberInfo(MemberGroup m) throws NumberFormatException, IOException {
    int index = console.getMemberIndex();
    console.showMemberInfo(index, m);
  }

  /**
   * Add member to the registry.
   *
   * @param m the member registry data.
   */
  public void addBoat(MemberGroup m) throws IOException {
    Member memberBoat = console.getMember(m);

    Boat boat = console.createBoat();
    memberBoat.addBoat(boat);
    console.boatAddedMessage();
  }

  /**
   * Call to remove a member from registry.
   *
   * @param m the member list registry data.
   */
  public void removeBoat(MemberGroup m) throws NumberFormatException, IOException {

    int index = console.getMemberIndex();
    if (index >= m.numberOfMember()) {
      console.memberNotExist();
    } else {
      int indexBoat = console.getBoatIndex();
      boolean n = m.getaMember(index).removeBoat(indexBoat);
      console.removeBoatPrompt(n);
    }
  }

  /**
   * Call to modify registry.
   *
   * @param m the member registry data.
   */
  public void changeMemberInfo(MemberGroup m) {
    int index = console.getMemberIndex();
    if (index >= m.numberOfMember()) {
      console.memberNotExist();
    } else {
      int optionNum = console.getOptionsMember();
      MemberOption optionMember = console.modifyMemberOptions(optionNum);
      switch (optionMember) {
        case changeMemberId:
          String id = console.createId();
          m.getaMember(index).setId(id);
          break;
        case changeMemberName:
          String name = console.createName();
          m.getaMember(index).setName(name);
          break;
        case changeMemberPersonalNumber:
          String personalNumber = console.createPersonalNumber();
          m.getaMember(index).setPersonalNumber(personalNumber);
          break;
        default:
          console.optionDoesNotExit();
          break;
      }

    }
  }

  /**
   * Call to modify registry.
   *
   * @param m the boat of existing members registry data.
   */

  public void changeBoatInfo(MemberGroup m) throws IOException {
    int index = console.getMemberIndex();
    if (index >= m.numberOfMember()) {
      console.memberNotExist();
    } else {
      int indexBoat = console.getBoatIndex();
      if (indexBoat >= m.getaMember(index).getBoatNumber()) {
        console.boatNotExist();
      } else {
        Boat boat = m.getaMember(index).getBoats().get(indexBoat);
        int optionNum = console.getOptionsBoat();
        BoatOption optionBoat = console.modifyBoatOptions(optionNum);
        switch (optionBoat) {
          case changeBoatType:
            Type type = console.getBoatTypePrompt(); /* get the type from cmdUI */
            boat.setType(type);
            break;
          case changeBoatDate:
            String dateString = console.createBoatDate();
            Date date = null;
            try {
              date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
              boat.setRegistration(date);
            } catch (ParseException e) {
              e.printStackTrace();
            }
            break;
          case changeBoatName:
            String boatName = console.createBoatName();
            boat.setName(boatName);
            break;
          default:
            console.optionDoesNotExit();
            break;
        }
      }
    }
  }

  /**
   * Get the prompt from the user.
   *
   * @param optionsChoices get the choices from the user input.
   * @throws IOException  if stream to file cannot be written to or closed.
   */
  public void getPrompt(Choices optionsChoices) throws IOException {

    switch (optionsChoices) {
      case Exit:
        break;
      case addMember:
        addMember(members);
        break;
      case removeMember:
        removeMember(members);
        break;
      case showMemberBoat:
        showMemberBoat(members);
        break;
      case showAllMember:
        showAllMember(members);
        break;
      case showMemberInfo:
        showMemberInfo(members);
        break;
      case addBoat:
        addBoat(members);
        break;
      case removeBoat:
        removeBoat(members);
        break;
      case changeMemberInfo:
        changeMemberInfo(members);
        break;
      case ChangeBoatInfo:
        changeBoatInfo(members);
        break;
      default:
        console.optionDoesNotExit();
        break;
    }
  }

}
