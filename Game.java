import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class Game {
    
    private ArrayList<Room> map;
    private User myUser;
    private String currentName;
    private int nCoordinate;
    private int sCoordinate;
    private int eCoordinate;
    private int wCoordinate;
    private Room currentLocation; 
    private String toTheNorth;
    private String toTheEast;
    private String toTheSouth;
    private String toTheWest;
    private boolean response;
    private int bassScriptTimeline; //script timelines are used to keep track of where players are in the storyline 
    private int neilsonScriptTimeline; 
    private int burtonScriptTimeline;
    private int lawnScriptTimeline;
    private Item duffel;
    private Item key;
    private Item flashlight;


    /**
     * constrcutor for the game 
     * initializes the map with all 8 rooms, the user, and the three items that are avaliable in the gamee
     */
    public Game(){
        this.map=new ArrayList<Room>();
        map.add(new Room("Neilson Library", "Neilson Library", -1, -1, 1, 3, true)); // Room 0
        map.add(new Room("Bass Hall", "Bass Hall", 0, 7, -1, 2, false));        // Room 1
        map.add(new Room("Burton Hall", "Burton Hall", 3, 1, 4, 5, false)); //Room 2
        map.add(new Room("Lawn", "Burton Lawn", 6, 0, 2, -1, false)); //Room 3
        map.add(new Room("Paradise Pond", "Paradise Pond", 2, -1, -1, -1, false)); //Room 4
        map.add(new Room("Botanic Gardens", "Botanic Gardens", -1, 2, -1, -1, false)); //Room 5
        map.add(new Room("Weinstein", "Weinstein", -1, -1, 3, -1, false)); //Room 6
        map.add(new Room("Alumnae Gym", "Alumnae Gym", -1, -1, -1, 1, false)); //Room 7
        this.myUser= new User(1); //player with no inventory starting in room 1, bass
        this.key= new Item("key", "unlocks Neilson");
        this.flashlight= new Item("flashlight","makes things bright");
        this.duffel= new Item ("duffel","holds the rare books collection");
    }    

    /**
     * prints out a nice header everytime the player enters a  room that tells them what room they have entered and what's around them 
     * @param location the users current location 
     */
    public void script(int location) {
        currentLocation = map.get(location);
        currentName = currentLocation.getName();
        nCoordinate = currentLocation.getN();
        if (nCoordinate == -1) {
            toTheNorth = "nothing";
        } else {
            toTheNorth = map.get(nCoordinate).getName();
        }
        sCoordinate = currentLocation.getS();
        if (sCoordinate == -1) {
            toTheSouth = "nothing";
        } else {
            toTheSouth = map.get(sCoordinate).getName();
        }
        eCoordinate = currentLocation.getE();
        if (eCoordinate == -1) {
            toTheEast = "nothing";
        } else {
            toTheEast = map.get(eCoordinate).getName();
        }
        wCoordinate = currentLocation.getW();
        if (wCoordinate == -1) {
            toTheWest = "nothing";
        } else {
            toTheWest = map.get(wCoordinate).getName();
        }
        System.out.println("\n");
        System.out.println("\033[3m"+"Welcome to " + currentName + ". To the North is " + toTheNorth + ". To the East is " + toTheEast + ". To the South is " + toTheSouth + ". To the West is " + toTheWest + "." + "\033[0m");
        System.out.println("\n");
    }


    /**
     * function that handles all of the storyline and item interaction depening on what room the user is in as well as their choices
     * @param userinputt the user input from the scanner
     */
    public void buildingScripts(String userInput) {
        
        //storylines contain multiple adventures/choices and ask prompts based on user choice 

        //if the user is in bass hall (starting location)
        if (myUser.getLocation() == 1) {
            if (burtonScriptTimeline == 2) {
                burtonScriptTimeline = 3;
            } 
            if ((bassScriptTimeline == 1 || bassScriptTimeline == 2) && (userInput == "s" || userInput == "e")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (bassScriptTimeline == 0) {
                bassScriptTimeline = 1;
                System.out.println("Upon entrance to Bass Hall, you encounter students studying quietly in the foyer area and a classroom you peek your head into. Do you want to further explore the first floor (1) or go to the second floor (2)?");
            } else if (bassScriptTimeline == 1) {
                if (userInput == "yes" || userInput == "no") {
                    System.out.println("Invalid response, please try again with 1 or 2.");
                } else if (userInput == "1" || userInput == "2") {
                    if (response == true) {
                        bassScriptTimeline = 2;
                        System.out.println("There are groups of students in all the classrooms on the second floor of Bass Hall. They are all talking loudly enough for you to hear in the hallway. You hear one of them mention campo being at Burton Hall. Do you want to go see what's going on? (yes/no)");
                    } else {
                        bassScriptTimeline = 2;
                        System.out.println("It is eerily quiet through the rest of the first floor. Once you reach the end of the hallway, you turn back. As you are walking back to the entrance, you hear someone say that campo is currently at Burton. Do you want to go investigate? (yes/no)");
                    }
                } else {
                    bassScriptTimeline = 0;
                    buildingScripts(userInput);
                } 
            } else if (bassScriptTimeline == 2) {
                if (userInput == "yes" || userInput == "no") {
                    if (response == true) {
                        bassScriptTimeline = 3;
                        System.out.println("You follow all the students to Burton Hall.");
                        myUser.move("w", map);
                        script(myUser.getLocation());
                        buildingScripts("yes");
                    } else {
                        System.out.println("You get trampled by the students going to investigate campo's appearance");
                        myUser.setAlive(false);
                    }
                } else {
                    System.out.println("Invalid response. Please use yes or no.");
                }
            } else if (bassScriptTimeline == 3) {
                System.out.println("Nothing has changed in Bass Hall. It is still quiet and students are still studying. Where do you want to go next?");
            }
        }

        // if the user is in Neilson library
        else if(myUser.getLocation() == 0){
            if (burtonScriptTimeline == 2) {
                burtonScriptTimeline = 3;
            } 
            if ((neilsonScriptTimeline >0) && (userInput == "n" || userInput == "e")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (neilsonScriptTimeline==0){
                System.out.println("Neilson is locked do you have a key to open the door? yes/no");
                neilsonScriptTimeline=1;
            } else if (neilsonScriptTimeline==1){
                if (userInput == "1" || userInput == "2") {
                    System.out.println("Invalid response. Please use yes or no.");
                } else {
                    if (response){
                        System.out.println("You made it to the library! It's pitch black and you can't see anything. Do you have a flashlight to use? (1) or will you continue in the dark? (2)");
                        neilsonScriptTimeline=2;
                    } else {
                        System.out.println("go find the key!!");
                        neilsonScriptTimeline=0;
                    }
                }
            } else if (neilsonScriptTimeline==2) { 
                if (userInput == "yes" || userInput == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if (response==false && myUser.getInventory().contains(flashlight)){
                    neilsonScriptTimeline=3;
                    System.out.println("Good work! You are in the front foyer of Neilson, do you take the elevator (1) or the stairs (2)");
                } else {
                    System.out.println("it's dark and the ghosts got you");
                    myUser.setAlive(false);
                }
            } else if (neilsonScriptTimeline==3) {
                if (userInput == "yes" || userInput == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if (response==false){
                   System.out.println("In the elevator you have met a ghost-");
                   System.out.println("Hello there! I didn't know they let humans in after dark- would you like to take a rest with me these books are making me awfully sleepy (1) or no (2)");
                   neilsonScriptTimeline=4;
                } else {
                    System.out.println("the stairs have taken you back to the lobby? that's weird");
                    neilsonScriptTimeline = 3;
                    System.out.println("You are in the front foyer of Neilson again, do you take the elevator (1) or the stairs (2)?");
                }
            } else if (neilsonScriptTimeline==4){
                if (userInput == "yes" || userInput == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if(response==false) {
                    System.out.println("yikes! the ghost convinved you to fall asleep and campo caught you in the morning!");
                    myUser.setAlive(false);
                } else {
                    neilsonScriptTimeline=5;
                    System.out.println("The ghost lets out a sob and mysteriously floats away");
                    System.out.println("ding! You have made it to the third floor!!");
                    System.out.println("The doors open- to your right is a closed room and to your left is the classics room. Do you want to go in to the classics room? yes/no");
                }
            } else if (neilsonScriptTimeline==5) {
                if (userInput == "1" || userInput == "2") {
                    System.out.println("Invalid response. Please use yes or no.");
                } else if (response) {
                    System.out.println("The rare books collection is sitting in front of you do you want to put it in your duffel (1) or leave(2)");
                    neilsonScriptTimeline=6;
                } else {
                    System.out.println("then why are you playing?!!");
                    myUser.setAlive(false);
                }
            } else if (neilsonScriptTimeline==6) {
                if (userInput == "yes" || userInput == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if (response==false  && myUser.getInventory().contains(duffel)){
                    System.out.println("congrats you win 100000000000000 now get out of here!");
                    myUser.setAlive(false);
                } else {
                    System.out.println("you have a great moral compass but you also lost sorry :()");
                    myUser.setAlive(false);
                }

            }
        
        // if the user is in burton 
        } else if (myUser.getLocation() == 2) {
            if ((burtonScriptTimeline > 0 && burtonScriptTimeline < 3) && (userInput == "s" || userInput == "w")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (burtonScriptTimeline == 0) {
                burtonScriptTimeline = 1;
                System.out.println("Campo is inside of Burton. Upon investigation, you see that someone broke the fish and crab tank by the entrance. Water is everywhere and there is a lot of chaos. You notice that a campo officer has dropped their keys. Do you want to give them back (1) or keep them (2)?");
            } else if (burtonScriptTimeline == 1) {
                if (userInput == "yes" || userInput == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if (response == true) {
                    burtonScriptTimeline = 2;
                    myUser.getInventory().add(key);
                    map.get(0).setLocked(false);
                    System.out.println("You have pocketed the keys and seem to have gotten away with it. Where do you want to go next?");
                } else {
                    System.out.println("You give campo the keys and they think that you were trying to steal them. They detain you for further questioning. You have failed this quest.");
                    myUser.setAlive(false);
                } 
            } else if (burtonScriptTimeline == 3) {
                if (userInput == "yes" || userInput == "no" || userInput == "1" || userInput == "2") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else
                System.out.println("The mess has been cleaned up. Campo is still here looking for their missing keys. They know you've taken them, and you are detained. You have failed this quest.");
                myUser.setAlive(false);
                }       
        } 
        
        // if the user is on the lawn 
        else if (myUser.getLocation() == 3) {
            if (burtonScriptTimeline == 2) {
                burtonScriptTimeline = 3;
            } 
            if ((lawnScriptTimeline > 0 && lawnScriptTimeline <5) && (userInput == "n" || userInput == "w")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (lawnScriptTimeline == 0 || lawnScriptTimeline == 2 || lawnScriptTimeline == 4) {
                lawnScriptTimeline = 1;
                System.out.println("There is a large section of grass with adirondack chairs. It's dark out but you can see a few trees. There is a dark object on the ground behind one of those trees. It looks like a piece of clothing or a bag. Do you want to investigate? (yes/no)");
            } else if (lawnScriptTimeline == 1) {
                if (response == true) {
                    lawnScriptTimeline = 3;
                    System.out.println("Its a duffel bag of some kind! It appears to have a flashlight in it. Do you want to take the bag and flashlight? (yes/no)");
                } else {
                    lawnScriptTimeline = 2;
                    System.out.println("No investigating today! Where to next?");
                }
            } else if (lawnScriptTimeline == 3) {
                if (response == true) {
                    myUser.getInventory().add(duffel);
                    myUser.getInventory().add(flashlight);
                    lawnScriptTimeline = 5;
                    System.out.println("Congrats, you have obtained a duffel bag and a flashlight! Where to next?");
                } else {
                    lawnScriptTimeline = 4;
                    System.out.println("Okay we will leave that there. Where to next?");
                }
            } else if (lawnScriptTimeline == 5) {
                System.out.println("There is nothing here. It's quite dark out. Where do you want to go next?");
            }
        
        // if the user is at the pond 
        } else if (myUser.getLocation()==4){
            System.out.println("What a slippery slope you've fallen down! Why would you go to the pond at night time?? You fell in :(");
            myUser.setAlive(false);
        
        // if the user is at the botanic gardens
        } else if (myUser.getLocation()==5){
            System.out.println("Oh no! The carnivorous plants have eaten you.");
            myUser.setAlive(false);

        // if the user is at weinstein 
        } else if (myUser.getLocation()==6){
            System.out.println("You got distracted by a poetry reading and did not complete the mission, better luck next time!");
            myUser.setAlive(false);
        
        // if the user is at the alumnae gym
        } else if (myUser.getLocation()==7){
            System.out.println("You lost track of time talking with your friends! Never go to the Alumnae Gym to get anything done.");
            myUser.setAlive(false);
        }
    }

            

    
    /**
     * main function where user input is collected and the game loop is run 
     * @param args
     */
    public static void main(String[] args) {
        // call the constructor for a new game 
        Game myGame= new Game();
        
        // all of the timlines for the scripts start at 0 
        myGame.bassScriptTimeline = 0;
        myGame.burtonScriptTimeline = 0;
        myGame.neilsonScriptTimeline = 0;
        myGame.lawnScriptTimeline = 0;

        //This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        //OPENEING
        System.out.println("**********************");
        System.out.println("NEILSON LIBRARY HEIST");
        System.out.println("**********************");

        System.out.println("\n");
        System.out.println("Welcome to Smith College, home of the rare books collection. You have been hired to steal the entire collection before dawn. If completed, you will be paid $1,000,000.00 in cash. If not, you will face the consequences of getting caught. Good luck.");

        //INSTRUCTIONS
        System.out.println("\n");
        System.out.println("\033[3m"+"You are currently located in Bass Hall. To the North is Neilson Library. To the East is the Alumnae Gym. To the South is nothing. To the West is Burton Hall. "+"\033[0m");
        System.out.println("\n"); 
        System.out.println("Your inventory is currently empty. You can access your inventory at any time by inputting inventory. You can drop items at any time by typing drop ____. Use n, s, e, w to move. You can move anywhere at any time. Respond to the game promts with yes/no or 1/2 depending on the prompt.");
        System.out.println("\n");        
        myGame.buildingScripts("yes");


        // do loop that gets all of the user input and calls the appropriate functions based on input 
        do {

            userResponse = userInput.nextLine().toLowerCase();
            
            // if the user wants to go north 
            if (userResponse.equals("n")) {
                myGame.neilsonScriptTimeline = 0;
                if (myGame.bassScriptTimeline < 3) {
                    myGame.bassScriptTimeline = 0;
                } if (myGame.burtonScriptTimeline < 2){
                    myGame.burtonScriptTimeline = 0;
                }

                // move them north 
                myGame.myUser.move("n", myGame.map);
                // tell them where they are 
                myGame.script(myGame.myUser.getLocation());
                // play the script based on their location 
                myGame.buildingScripts("n");
            
            // if the user wants to go south 
            } else if (userResponse.equals("s")) {
                myGame.neilsonScriptTimeline = 0;
                if (myGame.bassScriptTimeline < 3) {
                    myGame.bassScriptTimeline = 0;
                } if (myGame.burtonScriptTimeline < 2){
                    myGame.burtonScriptTimeline = 0;
                }
                myGame.myUser.move("s", myGame.map);
                myGame.script(myGame.myUser.getLocation());
                myGame.buildingScripts("s");
            
            // if the user wants to go east 
            } else if (userResponse.equals("e")) {
                myGame.neilsonScriptTimeline = 0;
                if (myGame.bassScriptTimeline < 3) {
                    myGame.bassScriptTimeline = 0;
                } if (myGame.burtonScriptTimeline < 2){
                    myGame.burtonScriptTimeline = 0;
                }
                myGame.myUser.move("e", myGame.map);
                myGame.script(myGame.myUser.getLocation());
                myGame.buildingScripts("e");
            
            // if the user wants to go west 
            } else if (userResponse.equals("w")) {
                myGame.neilsonScriptTimeline = 0;
                if (myGame.bassScriptTimeline < 3) {
                    myGame.bassScriptTimeline = 0;
                } if (myGame.burtonScriptTimeline < 2){
                    myGame.burtonScriptTimeline = 0;
                }
                myGame.myUser.move("w", myGame.map);
                myGame.script(myGame.myUser.getLocation());
                myGame.buildingScripts("w");

            //if the user enters 1 in response to a prompt 
            } else if (userResponse.equals("1")) {
                myGame.response = false;
                myGame.buildingScripts("1");
            
            // if the user enters 2 in response to a prompt 
            } else if (userResponse.equals("2")) {
                myGame.response = true;
                myGame.buildingScripts("2");
            
            // if the user enters yes in response to a prompt 
            } else if (userResponse.equals("yes")) {
                    myGame.response = true;
                    myGame.buildingScripts("yes");

            // if the user enters no in response to a prompt 
            } else if (userResponse.equals("no")) {
                    myGame.response = false;
                    myGame.buildingScripts("no");
            
            // if the users response contains the word inventory it prints out everything they currently have and the function within the game 
            } else if (userResponse.contains("inventory")) {
                myGame.myUser.printInventory();
                
            // if the user resonse contains drop it will drop the associated item 
            } else if (userResponse.contains("drop")) {
                String [] words=userResponse.split("\\s");
                myGame.myUser.dropItem(myGame.myUser.findItem(words[1]));
                if (!myGame.myUser.getInventory().contains(myGame.key)){
                    myGame.map.get(0).setLocked(true);
                }
            
            // if they enter a function we dont have they get an error message 
            } else {
                System.out.println("We don't have that function. Please try something else.");
            
            // if at any point the user dies the game loop ends and you are prompted to play again 
            } if (!myGame.myUser.getAlive()) {

                DisplayImage img = new DisplayImage();
                JFrame f = new JFrame();
                f.add(img);
                f.setSize(800,480);
                f.setVisible(true);
                System.out.println("Do you want to play again? (yes/no)");
            
                String playAgain = userInput.nextLine().toLowerCase();
            
                if (playAgain.equals("yes")) {
                    main(args);
                } else {
                    break; // Exit the loop and end the game
                }
            }


        } while (stillPlaying);

        // Tidy up
        userInput.close();

    }
}

