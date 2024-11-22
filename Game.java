import java.util.ArrayList;
import java.util.Scanner;

// Ive only just started this class because all i know is that it needs to have a map of all the rooms!

public class Game {
    
    ArrayList<Room> map;

    /**
     * constrcutor for the game 
     * initializes the map 
     */
    public Game(){
        this.map=new ArrayList<Room>();
        map.add(new Room("Neilson", "Neilson Library", -1, -1, 1, 3, true)); // Room 0
        map.add(new Room("Bass", "Bass Hall", 0, -1, -1, 2, false));        // Room 1
        map.add(new Room("Burton", "Burton Hall", 3, 1, -1, -1, false)); //Room 2
        map.add(new Room("lawn", "lawn", -1, 0, 2, -1, false)); //Room 3
    }   

    public static void main(String[] args) {
         //This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        //OPENEING
        System.out.println("Welcome to Smith College, home of the rare books collection. You have been hired to steal the entire collection before dawn. If completed, you will be paid $1,000,000.00 in cash. If not, you will face the consequences of getting caught. Good luck.");
    
        //INSTRUCITONS
        System.out.println("You are currently located.... To the North is.... To the South is.... To the East is.... To the West is.... Your inventory is currently empty.");        
    
        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        //do {
//             // ************************************************
//             // The stuff that happens in your game will go here
            userResponse = userInput.nextLine().toUpperCase();

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            //if (userResponse.equals("WIN") || userResponse.equals("LOSE")) {
                //stillPlaying = false;
            //}
        //} while (stillPlaying);

        // Tidy up
        //userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        // if (userResponse.equals("WIN")) {
        //     System.out.println("Yay, you won!");
        // } else { // userResponse.equals("LOSE")
        //     System.out.println("Better luck next time.");
        // }

   // }
    }
}


