import java.util.ArrayList; 
public class User {

    private ArrayList<Item> inventory; //inventory is an array list of items 
    private int location;   //index of the arraylist that corresponds to the room object 
    private boolean alive; //helps to determine if gameplay can continue or not 

    /**
     * constructor for the user that initializes the inventory and their first location 
     * @param location the initial loaction of the user 
     */
    public User(int location) {
        this.inventory=new ArrayList<Item>();
        this.location=location;
        this.alive=true;
    }

    /**
     * function that moves the player to the room that is in the direction they request to go
     * @param command the n,e,s,w command inputed from the user 
     * @param map the array list of rooms that make up the map 
     */
    public void move(String command,ArrayList<Room> map){
        if (command.equals("n")) {
            int nextRoomIndex = (map.get((location))).getN(); //geting the next room index
            if (nextRoomIndex != -1 && !map.get(nextRoomIndex).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else {
                if(nextRoomIndex == -1){
                    System.out.println("there's no room there");
                } else if(map.get(nextRoomIndex).islocked()){
                    System.out.println("this room is locked!");
                }
            }
        }

        if (command.equals("s")) {
            int nextRoomIndex = (map.get((location))).getS(); //geting the next room index
            if (nextRoomIndex != -1 && !map.get(nextRoomIndex).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else {
                if(nextRoomIndex == -1){
                    System.out.println("there's no room there");
                } else if(map.get(nextRoomIndex).islocked()){
                    System.out.println("this room is locked!");
                }
            }
        }

        if (command.equals("e")) {
            int nextRoomIndex = (map.get((location))).getE(); //geting the next room index
            if (nextRoomIndex != -1 && !map.get(nextRoomIndex).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else {
                if(nextRoomIndex == -1){
                    System.out.println("there's no room there");
                } else if(map.get(nextRoomIndex).islocked()){
                    System.out.println("this room is locked!");
                }
            }
        }

        if (command.equals("w")) {
            int nextRoomIndex = (map.get((location))).getW(); //geting the next room index
            if (nextRoomIndex != -1 && ! map.get(nextRoomIndex).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else {
                if(nextRoomIndex == -1){
                    System.out.println("there's no room there");
                } else if(map.get(nextRoomIndex).islocked()){
                    System.out.println("this room is locked!");
                }
            }
        }
        
    }


    /**
     * getter for the alive attribute 
     * @return wheter or not the user is alive
     */
    public boolean getAlive(){
        return this.alive;
    }

    /**
     * getter for the location attribute 
     * @return the location
     */
    public int getLocation(){
        return this.location;
    }

    /**
     * manipulator for the is alive attribute 
     * @param isAlive whether or not the user is alive
     */
    public void setAlive(boolean isAlive) {
        this.alive = isAlive;
    }

    /**
     * gets the room that the user is in  
     * @param map the array list of rooms that makes up the map 
     * @return the room obect that the user is currently in 
     */
    public Room checkRoom(ArrayList<Room> map){
        return map.get(location);
    }

    /**
     * function that gets the name of the room that the user is in 
     * @param map the map of rooms 
     * @return the name of the room that the user is in 
     */
    public String getRoomName(ArrayList<Room> map){
        return map.get(location).getName();
    }

    /**
     * function that uses the item by dropping it 
     * @param myitem the item the user wants to use 
     */
    public void useItem(Item myitem){
        System.out.println(" the " + myitem.getName()+ " can "+ myitem.getFunction());
        dropItem(myitem);
    }

    /**
     * function that adds an item to the players inventory if there is space 
     * @param myItem the item the player wants to pick up 
     * @return if the item grab was successful it will return true, returns false if there is not enough space in the inventory to grab the item 
     */
    public boolean grabItem(Item myItem){
        if (inventory.size()<3){
            inventory.add(myItem);
            System.out.println(myItem.getName() + " has been added to your inventory.");
            return true;
        } else {
            return false;
        }
    }

    /**
     * function that removes the item from the players inventory
     * @param myItem the item that the user wants to drop
     * @return if the drop was successful it will return true 
     */
    public boolean dropItem(Item myItem){
        if (inventory.contains(myItem)){
            inventory.remove(myItem);
            System.out.println(myItem.getName() + " has been removed from your inventory.");
            return true;
        } else {
            System.out.println("you don't have that item");
            return false;
        }
    }

    /**
     * function that prints out the list of items contained in the inventory along with their functions 
     */
    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + " which " + item.getFunction());
            }
        }
    }

    /**
     * function that looks for an item in the inventory based on the name 
     * @param name the name of the item as a string 
     * @return returns the item object based on the name string 
     */
    public Item findItem(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            } 
        } return null;
    }
    
    /**
     * getter for the inventory attribute 
     * @return the inventory of the user
     */
    public ArrayList<Item> getInventory(){
        return this.inventory;
    }
    
        
    //main function is used for testing 
    public static void main(String[] args) {
        User myUser= new User(1);
        Item key= new Item("key", "open neilson");
        ArrayList<Room> map=new ArrayList<Room>();
        map.add(new Room("Neilson Library", "Neilson Library", -1, -1, 1, 3, true)); // Room 0
        map.add(new Room("Bass Hall", "Bass Hall", 0, -1, -1, 2, false));        // Room 1
        map.add(new Room("Burton Hall", " Hall", 3, 1, -1, -1, false)); //Room 2
        map.add(new Room("Lawn", "There is a large section of grass with adirondack chairs. It's dark out but you can see a few trees. There is a dark object on the ground behind one of those trees. It looks like a piece of clothing or a bag.", -1, 0, 2, -1, false)); //Room 3
        myUser.grabItem(key);
        myUser.printInventory();
        myUser.useItem(key);
        myUser.printInventory();
        System.out.println(myUser.getRoomName(map));
        myUser.move("n", map);
        System.out.println(myUser.getRoomName(map));

    }
}