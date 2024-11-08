import java.util.Hashtable;

/**
 * A library with a collection of books and whether they are available
 */
public class Library extends Building {
  /**
   * A hashtable of strings -> title and boolean -> whether they are available
   */
  private Hashtable<String,Boolean> collection;
    
  /**
   * Default Constructor for the Library class
   */
  public Library() {
      super();
      this.collection = new Hashtable<String,Boolean>();
      System.out.println("You have built a library: 📖");
    }

  /**
   * Overrode constructor for the Library class given an address
   */
  public Library(String address) {
    super(address);
    this.collection = new Hashtable<String,Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overrode constructor for Library class given an address and name
   */
  public Library(String address, String name) {
    super(name,address);
    this.collection = new Hashtable<String,Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * overrides the showOptions() method in the parent class
   */
  @Override public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + checkOut(title)\n + returnBook(title)\n + printCollection()\n");
  }
  
    /**
     * Adds a new book to the collection
     * @param title of the book we are adding
     */
    public void addTitle(String title) {
      collection.put(title,true);
    }


    /**
     * Removes a book from the collection
     * @param title of the book we are removing
     * @return the title of the removed book
     */
    public String removeTitle(String title) {
      collection.remove(title,true);
      return title;
    }
    
    /**
     * "Checks out" a book by changing its availability value to false
     * @param title of the book we are checking out
     */
    public void checkOut(String title) {
      collection.put(title,false);
    }

    /**
     * "Returns" a book by changing its availability value to true
     * @param title of the book we are returning
     */
    public void returnBook(String title) {
      collection.put(title, true);
    }

    /**
     * Checks whether a title is in the hashtable of books
     * @param title we are checking
     * @return true or false
     */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

    /**
     * Checks whether a title in the collection is currently available
     * @param title of the book we are checking
     * @return true or false
     */
    public boolean isAvailable(String title) {
      return collection.get(title);
    }

    /**
     * Prints the entire collection of books and their availability
     */
    public void printCollection() {
      collection.forEach((key,value) -> {
        System.out.println(key + ":" + value);
      });
    }

    /**
     * Overrides the goToFloor() function in the superclass to allow travel between multiple floors at once
     */
    @Override public void goToFloor(int floorNum) {
      if (floorNum >= nFloors) {
        System.out.println("Error: the floor you want to go to does not exist :()");
      } else {
        this.activeFloor = floorNum;
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      }
    }
    public static void main(String[] args) {
      Library myLibrary = new Library();
      myLibrary.addTitle("Book");
      System.out.println(myLibrary.containsTitle("Book"));
      myLibrary.checkOut("Book");
      System.out.println(myLibrary.isAvailable("Book"));
      myLibrary.returnBook("Book");
      myLibrary.printCollection();
      myLibrary.removeTitle("Book");
      System.out.println(myLibrary.containsTitle("Book"));

    }
  
  }