package model;

import java.util.ArrayList;

/**
 * Member Registry.
 *
 */
public class MemberGroup {
  ArrayList<Member> members = new ArrayList<Member>();

  /**
   * Call to fetch member list from registry.
   *
   * @return return the member list to the Controller.
   */
  public ArrayList<Member> getMembers() {
    return members;
  }

  /**
   * set the default member list.
   *
   * @param members set the members list.
   */
  public void setMembers(ArrayList<Member> members) {
    this.members = members;
  }

  /**
   * Call to add a member to registry.
   *
   * @param m add the member to list registry data.
   * @return true if the memberId is unique
   */
  public boolean addMember(Member m) {
    String mid = m.getId();
    for (Member member : members) {
      if (member.getId().equals(mid)) {
        return false;
      }
    }
    members.add(m);
    return true;
  }

  /**
   * Id as a string.
   *
   * @param index the member index number.
   * @return true if the member exists in the ArrayList else false if not.
   */
  public boolean removeMember(int index) {
    if (index < members.size()) {
      members.remove(index);
      return true;

    } else {
      return false;

    }

  }

  /**
   * call to get total member number.
   *
   * @return the total number of member list.
   */
  public int numberOfMember() {
    return members.size();
  }

  /**
   * get the member object form the member list.
   *
   * @param index the member index number.
   * @return the member.
   */

  public Member getaMember(int index) {
    if (index >= members.size()) {
      return null;
    } else {
      return members.get(index);
    }
  }

}
