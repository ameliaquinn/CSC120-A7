import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library());
        myMap.addBuilding(new Library("7 Neilson Drive Northampton MA 010643"));
        myMap.addBuilding(new Library("Josten Library","122 Green Street, Northampton MA 01063"));
        myMap.addBuilding(new Cafe());
        myMap.addBuilding(new Cafe(50));
        myMap.addBuilding(new House(false));
        House northropHouse = new House(true);
        northropHouse.moveIn("Amelia");
        northropHouse.moveIn("Roommate 1", "Roommate 2");
        northropHouse.moveOut("Roommate 1", "Roommate 2");
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct Northampton Ma 01063"));
        System.out.println(myMap);
    }
    
}
