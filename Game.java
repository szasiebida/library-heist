import java.util.ArrayList;

// Ive only just started this class because all i know is that it needs to have a map of all the rooms!

public class Game {
    
    ArrayList<Room> map;


    public Game(){
        this.map=new ArrayList<Room>();
        map.add(new Room("Neilson", "Neilson Library", -1, 1, -1, -1)); // Room 0
        map.add(new Room("Seelye", "Seelye Hall", 0, -1, 2, -1));       // Room 1
        map.add(new Room("Bass", "Bass Hall", -1, -1, -1, 1));         // Room 2
    }


    public static void main(String[] args) {
        
    }
}
