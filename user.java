public class user {

    private String inventory; //WHAT IF WE TAKE IN A STRING AND THEN SEGMENT IT AND THEN WE CAN MAKE IT AN ARRAYLIST
    private String location; //SHOULD LOCATION BE A HASTABLE (X,Y)

    public user(String inventory, String location) {
        this.inventory = inventory;
        this.location = location;
    }

    public String move(int x, int y){
        xlocation = xlocation + x;
        ylocation = yloaction + y;
        return location;
    }

    public String useitem {
        //remove item from inventory
        //return inventory
    }
                // HEY WHATS THE DIFF BETWEEN THESE TWO
    public String grabitem {
        //add to inventory
        //return inventory
    }

    
}