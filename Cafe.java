/**
 * A Cafe with inventory of different ingredients
 */
public class Cafe extends Building {
    /**
     * Number of ounces of coffee
     */
    private int nCoffeeOunces;
    /**
     * Number of sugar packets
     */
    private int nSugarPackets;
    /**
     * Number of creams
     */
    private int nCreams;
    /** 
     * Number of cups
     */
    private int nCups;

    /** 
     * Default Cafe constructor
     */
    public Cafe() {
        super();
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
        System.out.println("You have built a cafe: ☕");
    }

   /**
    * Overrode Cafe constructor with only amount of coffee
    * @param nCoffeeOunces
    */
    public Cafe(int nCoffeeOunces) {
        super();
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
    }
    /**
     * Full constructor for the Cafe class
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super();
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overrides the showOptions() method in the Building class to reflect this subclass
     */
    @Override public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + sellCoffee(s,sp,cr) + restock(s,sp,cr,c)");
    }

    /**
     * Overrides the goToFloor() method in the superclass to not permit movement off the first floor
     */
    @Override public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum > 1 ) {
            throw new RuntimeException("Sorry, you can't travel off the first floor");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * First checks that the inventory is sufficient to create a coffee with these ingredients (if not, it restocks the inventory)
     * Sells a coffee by removing the ingredients from the cafe's inventory
     * @param size # of coffee ounces in cofee sold
     * @param nSugarPackets # of sugar packets
     * @param nCreams # of creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >=nCreams && this.nCups >= 1) {
            nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            nCups -= 1;
            System.out.println("Coffee successfully sold!");
        } else {
            restock(size, nSugarPackets, nCreams, 1);
            System.out.println("Restocked! Please try again.");
        }
        
    }

    /**
     * Restocks inventory by adding the given numbers for each variable to the current inventory
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe(10,5,10,5);
        myCafe.sellCoffee(2,3,4);
        myCafe.sellCoffee(100,100,100);
    }
    
}
