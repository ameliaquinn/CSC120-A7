import java.util.ArrayList;
import java.lang.Math;

/* This is a stub for the House class */

/**
 * Represents a house with a certain number of residents that either does or doesn't have a dining room
 */
public class House extends Building {

  /**
   * The list of residents in the house
   */
  private ArrayList<String> residents;
  /**
   * Whether or not there is a dining room in the house
   */
  private boolean hasDiningRoom;


  /**
   * The constructor for a new house
   * @param hasDiningRoom whether the house has a dining room 
   */
  public House(boolean hasDiningRoom) {
    super("name","address",1);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overrides the showOptions() method in the Building class to reflect this subclass
   */
  @Override public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + moveIn(Name) + moveOut(Name)");
  }

  /**
   * Overrides the goToFloor() function in the superclass to allow travel between multiple
   * floors at once if the house has an elevator
   */
  @Override public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
  }
  if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
  }
  if (Math.abs(floorNum - activeFloor)>1 && hasElevator == false) {
    throw new RuntimeException("You cannot travel between more than 1 floor at a time without an elevator.");
  }
  System.out.println("You are now on floor #" + floorNum + " of " + this.name);
  this.activeFloor = floorNum;
  }

  /**
   * Accessor for hasDiningRoom
   * @return whether the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Accessor for the number of residents
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Adds a new person to the list of residents
   * @param Name of the person moving in
   */
  public void moveIn(String Name) {
    residents.add(Name);
  }

  /**
   * Overloaded moveIn method allowing you to move in 2 people at once!
   * @param name1
   * @param name2
   */
  public void moveIn(String name1, String name2) {
    residents.add(name1);
    residents.add(name2);
  }

  /**
   * Removes a person from the list of residents
   * @param Name of the person moving out
   * @return the name of the person who moved out
   */
  public String moveOut(String Name) {
    residents.remove(Name);
    return Name;
  }

  /**
   * Overloaded moveOut method that allows you to move out 2 people at once!
   * @param name1
   * @param name2
   * @return an ArrayList of their names
   */
  public ArrayList<String> moveOut (String name1, String name2) {
    residents.remove(name1);
    residents.remove(name2);
    ArrayList<String> names = new ArrayList<String>();
    names.add(name1);
    names.add(name2);
    return names;
  }

  /**
   *  Checks whether a person is a resident of the house
   * @param Person we are checking
   * @return whether the person is a resident
   */
  public Boolean isResident(String Person) {
    if (residents.contains(Person)) {
      return true;
    } else {
      return false;
    }
  }
  

  public static void main(String[] args) {
    House myHouse = new House(true);
    myHouse.moveIn("Amelia");
    System.out.println(myHouse.isResident("Amelia"));
    System.out.println(myHouse.nResidents());
    myHouse.moveOut("Amelia");
    System.out.println(myHouse.nResidents());
  }

}