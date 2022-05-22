package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Boat.Type;

/**
 * Default Data for testing, this class has only one attribute: members.
 */
public class HardCodeData {

  private MemberGroup members;

  /**
   * Constructor Class.
   */
  public MemberGroup getMembers() {
    return members;
  }

  /**
   * set the MemeberList.
   *
   * @param members The registry to manipulate.
   */
  public void setMembers(MemberGroup members) {
    this.members = members;
  }

  /**
   * construct and initialise the MemeberList.
   * 
   */
  public HardCodeData() throws ParseException {
    members = new MemberGroup(); /* Collections of Members */

    Member m1 = new Member("12D35F", "John", "123456");
    /* Add boat */
    Boat b1 = new Boat(Type.Canoe, new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2021"));
    b1.setName("Diamond");
    m1.addBoat(b1);

    /* add Boat b2 */
    Boat b2 = new Boat(Type.Sailboat, new SimpleDateFormat("dd/MM/yyyy").parse("11/09/2021"));
    b2.setName("Titan");
    m1.addBoat(b2);

    members.addMember(m1);

    Member m2 = new Member("32H89C", "Daniel", "654321");
    members.addMember(m2);

    Member m3 = new Member("98J56H", "Bill", "321654");
    members.addMember(m3);

  }

}
