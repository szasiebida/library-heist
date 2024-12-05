import java.util.ArrayList;
import java.util.Scanner;

// Ive only just started this class because all i know is that it needs to have a map of all the rooms!

public class Game {
    
    ArrayList<Room> map;
    User myUser;
    public int location;
    public String currentname;
    public int ncoordinate;
    public int scoordinate;
    public int ecoordinate;
    public int wcoordinate;
    Room currentlocation;
    public String tothenorth;
    public String tothesouth;
    public String totheeast;
    public String tothewest;

    /**
     * constrcutor for the game 
     * initializes the map 
     */
    public Game(){
        this.map=new ArrayList<Room>();
        map.add(new Room("Neilson Library", "Neilson Library", -1, -1, 1, 3, true)); // Room 0
        map.add(new Room("Bass Hall", "Bass Hall", 0, -1, -1, 2, false));        // Room 1
        map.add(new Room("Burton Hall", " Hall", 3, 1, -1, -1, false)); //Room 2
        map.add(new Room("Lawn", "There is a large section of grass with adirondack chairs. It's dark out but you can see a few trees. There is a dark object on the ground behind one of those trees. It looks like a piece of clothing or a bag.", -1, 0, 2, -1, false)); //Room 3
        this.myUser= new User(1); //player with no inventory starting in room 1, bass
        Item key= new Item("key", "unlocks Neilson");
    }    

    public void play(){
        this.myUser.move("n",this.map);
    }

    public void script(int location) {
        currentlocation = map.get(location);
        currentname = currentlocation.getName();
        ncoordinate = currentlocation.getN();
        if (ncoordinate == -1) {
            tothenorth = "nothing";
        } else {
            tothenorth = map.get(ncoordinate).getName();
        }
        scoordinate = currentlocation.getS();
        if (scoordinate == -1) {
            tothesouth = "nothing";
        } else {
            tothesouth = map.get(scoordinate).getName();
        }
        ecoordinate = currentlocation.getE();
        if (ecoordinate == -1) {
            totheeast = "nothing";
        } else {
            totheeast = map.get(ecoordinate).getName();
        }
        wcoordinate = currentlocation.getW();
        if (ncoordinate == -1) {
            tothewest = "nothing";
        } else {
            tothewest = map.get(wcoordinate).getName();
        }
        System.out.println("Welcome to " + currentname + ". To the North is " + tothenorth + ". To the East is " + totheeast + ". To the South is " + tothesouth + ". To the West is " + tothewest);
        //if (myUser.location == 
    }

    public static void main(String[] args) {

        Game myGame= new Game();
        myGame.play();

         //This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        //OPENEING
        System.out.println("Welcome to Smith College, home of the rare books collection. You have been hired to steal the entire collection before dawn. If completed, you will be paid $1,000,000.00 in cash. If not, you will face the consequences of getting caught. Good luck.");
    
        //INSTRUCITONS
        System.out.println("You are currently located in Bass Hall. To the North is Neilson Library. To the East is nothing. To the South is nothing. To the West is Burton Hall. Your inventory is currently empty. Where would you like to go? Use n, s, e, w to move.");        
    
        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {

            userResponse = userInput.nextLine().toLowerCase();

            if (userResponse.equals("n")) {
                myGame.myUser.move("n", myGame.map);
                myGame.script(myGame.myUser.location);
            } else if (userResponse.equals("s")) {
                myGame.myUser.move("s", myGame.map);
            } else if (userResponse.equals("e")) {
                myGame.myUser.move("e", myGame.map);
            } else if (userResponse.equals("w")) {
                myGame.myUser.move("w", myGame.map);
            } else if (userResponse.contains("use")) {
                //calluseitem
            } else if (userResponse.contains("grab")||userResponse.contains("take")) {
                //callgrabitem
            } else {
                System.out.println("We don't have that function. Please try something else.");
            }


        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        // if (userResponse.equals("WIN")) {
        //     System.out.println("Yay, you won!");
        // } else { // userResponse.equals("LOSE")
        //     System.out.println("Better luck next time.");
        // }

   // }
    }
}


