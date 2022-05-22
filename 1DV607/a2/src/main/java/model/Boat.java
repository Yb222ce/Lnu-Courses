package model;

import java.util.Date;

/**
 * Boat class has three attributes: type, registration and name.
 */
public class Boat {
  private Type type;
  private Date registration;
  private String name;

  /**
   * get boat name.
   */
  public String getName() {
    return name;
  }

  /**
   * set boat name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * BoatType Enumeration.
   */
  public enum Type {
    Sailboat, Motorsailer, Canoe
  }

  /**
   * Boat class Constructor.
   *
   * @param type         set the boat type.
   * @param registration set the registry date.
   */
  public Boat(Type type, Date registration) {
    /* Date is mutable, so use deep copy */
    this.type = type;
    this.registration = new Date(registration.getTime());
  }

  /**
   * Fetch boat type.
   *
   * @return get the type of this boat.
   */
  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  /**
   * Fetch boat Date.
   *
   * @return get the registry of this boat.
   */
  public Date getRegistration() {
    return registration;
  }

  public void setRegistration(Date registration) {
    /* Date is mutable, so use deep copy */
    this.registration = new Date(registration.getTime());
  }

}
