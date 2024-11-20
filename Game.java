import java.util.ArrayList;

// Ive only just started this class because all i know is that it needs to have a map of all the rooms!

public class Game {
    
    ArrayList<Room> map;


    public Game(){
        this.map=new ArrayList<Room>();
        map.add(new Room("Neilson", "Neilson Library", -1, -1, 1, 3, true)); // Room 0
        map.add(new Room("Bass", "Bass Hall", 0, -1, -1, 2, false));        // Room 1
        map.add(new Room("Burton", "Burton Hall", 3, 1, -1, -1, false)); //Room 2
        map.add(new Room("lawn", "lawn", -1, 0, 2, -1, false)); //Room 3
    }   


    public static void main(String[] args) {
        
    }
}
