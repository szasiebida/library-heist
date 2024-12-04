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


    public static void main(String[] args) {
        
    }
}