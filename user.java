import java.util.ArrayList; // import the ArrayList class
public class User {

    ArrayList<Item> inventory;
    int location; //index of the arraylist that corresponds to the room 

    public User( int location ) {
        this.inventory=new ArrayList<Item>();
        this.location=location;
    }

    public void move(String command,ArrayList<Room> map){
        if (command.equals("n")) {
            int nextRoomIndex = (map.get((location))).getN(); //geting the next room index
            if (nextRoomIndex != -1) {
                this.location = nextRoomIndex; // Update to the new room index
            }
        }

        if (command.equals("s")) {
            int nextRoomIndex = (map.get((location))).getS(); //geting the next room index
            if (nextRoomIndex != -1) {
                this.location = nextRoomIndex; // Update to the new room index
            }
        }

        if (command.equals("e")) {
            int nextRoomIndex = (map.get((location))).getE(); //geting the next room index
            if (nextRoomIndex != -1) {
                this.location = nextRoomIndex; // Update to the new room index
            }
        }

        if (command.equals("w")) {
            int nextRoomIndex = (map.get((location))).getW(); //geting the next room index
            if (nextRoomIndex != -1) {
                this.location = nextRoomIndex; // Update to the new room index
            }
        }
        
    }

    public Room checkRoom(ArrayList<Room> map){
        return map.get(location);
    }

    public void useItem(Item myitem){
        System.out.println("the" + myitem.getName()+ "has"+ myitem.getFunction());
    }

    //returns false if there is not enough space in the inventory to grab the item 
    //i imagine there could be a print statement related to the boolean value outputed so if false then "you can't add that"
    public boolean grabItem(Item myItem){
        if (this.inventory.size()<10){
            inventory.add(myItem);
            return true;
        } else 
            return false;
    }

    public boolean dropItem(Item myItem){
        if (this.inventory.contains(myItem)){
            this.inventory.remove(myItem);
            return true;
        } else 
            return false;
    }
        

    public static void main(String[] args) {
        
    }
}