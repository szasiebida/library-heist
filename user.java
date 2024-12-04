import java.util.ArrayList; 
public class User {

    ArrayList<Item> inventory;
    int location;   //index of the arraylist that corresponds to the room object 

    public User( int location ) {
        this.inventory=new ArrayList<Item>();
        this.location=location;
    }

    /**
     * function that moves the player to the room that is in the direction they request to go
     * @param command the n,e,s,w command inputed from the user 
     * @param map the array list of rooms that make up the map 
     */
    public void move(String command,ArrayList<Room> map){
        if (command.equals("n")) {
            int nextRoomIndex = (map.get((location))).getN(); //geting the next room index
            if (nextRoomIndex != -1 && ! map.get(location).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else 
                if(nextRoomIndex != -1){
                    System.out.println("there's no room there");
                } else if(map.get(location).islocked()){
                    System.out.println("this room is locked!");
                }
        }

        if (command.equals("s")) {
            int nextRoomIndex = (map.get((location))).getS(); //geting the next room index
            if (nextRoomIndex != -1 && ! map.get(location).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else 
                if(nextRoomIndex != -1){
                    System.out.println("there's no room there");
                } else if(map.get(location).islocked()){
                    System.out.println("this room is locked!");
                }
        }

        if (command.equals("e")) {
            int nextRoomIndex = (map.get((location))).getE(); //geting the next room index
            if (nextRoomIndex != -1 && ! map.get(location).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else 
                if(nextRoomIndex != -1){
                    System.out.println("there's no room there");
                } else if(map.get(location).islocked()){
                    System.out.println("this room is locked!");
                }
        }

        if (command.equals("w")) {
            int nextRoomIndex = (map.get((location))).getW(); //geting the next room index
            if (nextRoomIndex != -1 && ! map.get(location).islocked()) {
                this.location = nextRoomIndex; // Update to the new room index
            } else 
                if(nextRoomIndex != -1){
                    System.out.println("there's no room there");
                } else if(map.get(location).islocked()){
                    System.out.println("this room is locked!");
                }
        }
        
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

    public void useItem(Item myitem){
        System.out.println("the" + myitem.getName()+ "has"+ myitem.getFunction());
    }

    //returns false if there is not enough space in the inventory to grab the item 
    //i imagine there could be a print statement related to the boolean value outputed so if false then "you can't add that"
    /**
     * function that adds an item to the players inventory if there is space 
     * @param myItem the item the player wants to pick up 
     * @return if the item grab was successful it will return true 
     */
    public boolean grabItem(Item myItem){
        if (inventory.size()<3){
            inventory.add(myItem);
            System.out.println(myItem.getName() + " has been added to your inventory.");
            return true;
        } else 
            return false;
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
        } else 
            return false;
    }

    /**
     * function that prints out the list of items contained in the inventory 
     */
    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + "which can " + item.getFunction());
            }
        }
    }
        

    public static void main(String[] args) {
        
    }
}