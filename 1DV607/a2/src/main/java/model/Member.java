package model;

import java.util.ArrayList;

/**
 * Member class has three attributes: id, name and personalNumber.
 */
public class Member {
  private String id;
  private String name;
  private String personalNumber;
  private ArrayList<Boat> boats;

  /**
   * Default Member Class Constructor.
   */
  public Member() {
    boats = new ArrayList<Boat>();
    // this.boats = null; /*The Member doesn't have any boat by default*/
  }

  /**
   * Another Constructor.
   */
  public Member(String id, String name, String personalNumber) {
    this.id = id;
    this.name = name;
    this.personalNumber = personalNumber;
    boats = new ArrayList<Boat>();
    // this.boats = null; /*The Member doesn't have any boat by default*/

  }

  /**
   * add boat to a member.
   */
  public void addBoat(Boat boat) {
    boats.add(boat);
  }

  /**
   * remove a boat from a member.
   *
   * @param index boat index.
   * @return true if the boat exists in the registry else false.
   */
  public boolean removeBoat(int index) {
    if (index >= boats.size()) {
      return false;

    } else {
      boats.remove(index);
      return true;
    }
  }

  /**
   * get Boats ArrayList.
   *
   * @return whole boat list of this member
   */
  public ArrayList<Boat> getBoats() {
    return boats;
  }

  public void setBoats(ArrayList<Boat> boats) {
    this.boats = boats;
  }

  public String getId() {
    return id;
  }

  public int getBoatNumber() {
    return boats.size();
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPersonalNumber() {
    return personalNumber;
  }

  public void setPersonalNumber(String personalNumber) {
    this.personalNumber = personalNumber;
  }

}
