import java.util.ArrayList; // import the ArrayList class
public class User {

    private String initialInventory; //WHAT IF WE TAKE IN A STRING AND THEN SEGMENT IT AND THEN WE CAN MAKE IT AN ARRAYLIST
    private String location; //SHOULD LOCATION BE A HASTABLE (X,Y)

    public User(String initialInventory, String location) {
        this.initialInventory = initialInventory;
        this.location = location;
        // append the existing inventory to an arraylist and then the arraylist becomes the offical inventory
    }

    public String move(int x, int y){
        // xlocation = xlocation + x;
        // ylocation = yloaction + y;
        return this.location;
    }

    public String useitem() {
        //remove item from inventory
        return this.initialInventory;
    }
                // HEY WHATS THE DIFF BETWEEN THESE TWO
    public String grabitem() {
        //add to inventory
        return this.initialInventory;
    }

    public static void main(String[] args) {
        
    }
}