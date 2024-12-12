import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

//bug when given a prompt cannot enter a direction
//probably should not increment the storyline until the user responds with one or 2  
//everytime you move to a new room should call the script that tells you where you are and whats around you 

//paradise pond + time things
//picture 

public class Game {
    
    ArrayList<Room> map;
    User myUser;
    public int location;
    public String currentname;
    public int ncoordinate;
    public int scoordinate;
    public int ecoordinate;
    public int wcoordinate;
    Room currentlocation; //to get currentlocation myUser.location() --> room object myUser.getname()--> name of the room
    public String tothenorth;
    public String tothesouth;
    public String totheeast;
    public String tothewest;
    public boolean response;
    public int bassscripttimeline;
    public int neilsonscripttimeline;
    public int burtonscripttimeline;
    public int lawnscripttimeline;
    Item duffel;
    Item key;
    Item flashlight;


    /**
     * constrcutor for the game 
     * initializes the map 
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
        //map.add(new Room("Paradise Pond", "Whoops, you fell in. Goodbye.", 0, 0, 0, 0, false));
        this.myUser= new User(1); //player with no inventory starting in room 1, bass
        this.key= new Item("key", "unlocks Neilson");
        this.flashlight= new Item("flashlight","make things bright");
        this.duffel= new Item ("duffel","for bookks");
    }    

    public void play(){
        //this.myUser.move("n",this.map);
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
        if (wcoordinate == -1) {
            tothewest = "nothing";
        } else {
            tothewest = map.get(wcoordinate).getName();
        }
        System.out.println("\n");
        System.out.println("\033[3m"+"Welcome to " + currentname + ". To the North is " + tothenorth + ". To the East is " + totheeast + ". To the South is " + tothesouth + ". To the West is " + tothewest + "." + "\033[0m");
        System.out.println("\n");
    }

    //i dont thing building script needs to take in locations 
    //key functionality 
    //fix the timeline update thingy
    //inspect or something 
    public void buildingscripts(String userinputt) {
        //use yes no instead of y/n
        if (myUser.location == 1) {
            if (burtonscripttimeline == 2) {
                burtonscripttimeline = 3;
            } 
            if ((bassscripttimeline == 1 || bassscripttimeline == 2) && (userinputt == "s" || userinputt == "e")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (bassscripttimeline == 0) {
                bassscripttimeline = 1;
                System.out.println("Upon entrance to Bass Hall, you encounter students studying quietly in the foyer area and a classroom you peek your head into. Do you want to further explore the first floor (1) or go to the second floor (2)?");
            } else if (bassscripttimeline == 1) {
                if (userinputt == "yes" || userinputt == "no") {
                    System.out.println("Invalid response, please try again with 1 or 2.");
                } else if (userinputt == "1" || userinputt == "2") {
                    if (response == true) {
                        bassscripttimeline = 2;
                        System.out.println("There are groups of students in all the classrooms on the second floor of Bass Hall. They are all talking loudly enough for you to hear in the hallway. You hear one of them mention campo being at Burton Hall. Do you want to go see what's going on? (yes/no)");
                    } else {
                        bassscripttimeline = 2;
                        System.out.println("It is eerily quiet through the rest of the first floor. Once you reach the end of the hallway, you turn back. As you are walking back to the entrance, you hear someone say that campo is currently at Burton. Do you want to go investigate? (yes/no)");
                    }
                } else {
                    bassscripttimeline = 0;
                    buildingscripts(userinputt);
                } 
            } else if (bassscripttimeline == 2) {
                if (userinputt == "yes" || userinputt == "no") {
                    if (response == true) {
                        bassscripttimeline = 3;
                        System.out.println("You follow all the students to Burton Hall.");
                        myUser.move("w", map);
                        script(myUser.location);
                        buildingscripts("yes");
                    } else {
                        System.out.println("You get trampled by the students going to investigate campo's appearance");
                        myUser.alive=false;
                    }
                } else {
                    System.out.println("Invalid response. Please use yes or no.");
                }
            } else if (bassscripttimeline == 3) {
                // script(myUser.location);
                System.out.println("Nothing has changed in Bass Hall. It is still quiet and students are still studying. Where do you want to go next?");
            }
        }

        else if(myUser.location == 0){
            if (burtonscripttimeline == 2) {
                burtonscripttimeline = 3;
            } 
            if ((neilsonscripttimeline >0) && (userinputt == "n" || userinputt == "e")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (neilsonscripttimeline==0){
                //script(myUser.location);
                System.out.println("Neilson is locked do you have a key to open the door? yes/no");
                neilsonscripttimeline=1;
            } else if (neilsonscripttimeline==1){
                if (userinputt == "1" || userinputt == "2") {
                    System.out.println("Invalid response. Please use yes or no.");
                } else {
                    if (response){
                        System.out.println("You made it to the library! It's pitch black and you can't see anything. Do you have a flashlight to use? (1) or will you continue in the dark? (2)");
                        neilsonscripttimeline=2;
                    } else {
                        System.out.println("go find the key!!");
                        neilsonscripttimeline=0;
                    }
                }
            } else if (neilsonscripttimeline==2) { 
                if (userinputt == "yes" || userinputt == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if (response==false && myUser.inventory.contains(flashlight)){
                    neilsonscripttimeline=3;
                    System.out.println("Good work! You are in the front foyer of Neilson, do you take the elevator (1) or the stairs (2)");
                } else {
                    System.out.println("it's dark and the ghosts got you");
                    myUser.alive=false;
                }
            } else if (neilsonscripttimeline==3) {
                if (userinputt == "yes" || userinputt == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if (response==false){
                   System.out.println("In the elevator you have met a ghost-");
                   System.out.println("Hello there! I didn't know they let humans in after dark- would you like to take a rest with me these books are making me awfully sleepy (1) or no (2)");
                   neilsonscripttimeline=4;
                } else {
                    System.out.println("the stairs have taken you back to the lobby? that's weird");
                    neilsonscripttimeline = 3;
                    System.out.println("You are in the front foyer of Neilson again, do you take the elevator (1) or the stairs (2)?");
                }
            } else if (neilsonscripttimeline==4){
                if (userinputt == "yes" || userinputt == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if(response==false) {
                    System.out.println("yikes! the ghost convinved you to fall asleep and campo caught you in the morning!");
                    myUser.alive=false;
                } else {
                    neilsonscripttimeline=5;
                    System.out.println("The ghost lets out a sob and mysteriously floats away");
                    System.out.println("ding! You have made it to the third floor!!");
                    System.out.println("The doors open- to your right is a closed room and to your left is the classics room do you want to go in? yes/no");
                }
            } else if (neilsonscripttimeline==5) {
                if (userinputt == "1" || userinputt == "2") {
                    System.out.println("Invalid response. Please use yes or no.");
                } else if (response) {
                    System.out.println("The rare books collection is sitting in front of you do you want to put it in your duffel (1) or leave(2)");
                    neilsonscripttimeline=6;
                } else {
                    System.out.println("then why are you playing?!!");
                    myUser.alive=false;
                }
            } else if (neilsonscripttimeline==6) {
                if (userinputt == "yes" || userinputt == "no") {
                    System.out.println("Invalid response. Please use 1 or 2.");
                } else if (response==false  && myUser.inventory.contains(duffel)){
                    System.out.println("congrats you win 100000000000000 now get out of here!");
                    myUser.alive=false;
                } else {
                    System.out.println("you have a great moral compass but you also lost sorry :()");
                    myUser.alive=false;
                }

            }
        } else if (myUser.location == 2) {
            if ((burtonscripttimeline > 0 && burtonscripttimeline < 3) && (userinputt == "s" || userinputt == "w")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (burtonscripttimeline == 0) {
                burtonscripttimeline = 1;
                System.out.println("Campo is inside of Burton. Upon investigation, you see that someone broke the fish and crab tank by the entrance. Water is everywhere and there is a lot of chaos. You notice that a campo officer has dropped their keys. Do you want to give them back (1) or keep them (2)?");
            } else if (burtonscripttimeline == 1) {
                if (response == true) {
                    burtonscripttimeline = 2;
                    myUser.inventory.add(key);
                    map.get(0).setLocked(false);
                    System.out.println("You have pocketed the keys and seem to have gotten away with it. Where do you want to go next?");
                } else {
                    System.out.println("You give campo the keys and they think that you were trying to steal them. They detain you for further questioning. You have failed this quest.");
                    myUser.alive=false;
                } 
            } else if (burtonscripttimeline == 3) {
                System.out.println("The mess has been cleaned up. Campo is still here looking for their missing keys. They know you've taken them, and you are detained. You have failed this quest.");
                myUser.alive=false;
                }       
        } 
        
        else if (myUser.location == 3) {
            if (burtonscripttimeline == 2) {
                burtonscripttimeline = 3;
            } 
            if ((lawnscripttimeline > 0 && lawnscripttimeline <5) && (userinputt == "n" || userinputt == "w")) {
                System.out.println("There is nothing there. Try again. Where do you want to go?");
            } else if (lawnscripttimeline == 0 || lawnscripttimeline == 2 || lawnscripttimeline == 4) {
                lawnscripttimeline = 1;
                // script(myUser.location);
                System.out.println("There is a large section of grass with adirondack chairs. It's dark out but you can see a few trees. There is a dark object on the ground behind one of those trees. It looks like a piece of clothing or a bag. Do you want to investigate? (yes or no)");
            } else if (lawnscripttimeline == 1) {
                if (response == true) {
                    lawnscripttimeline = 3;
                    System.out.println("Its a duffel bag of some kind! It appears to have a flashlight in it. Do you want to take the bag and flashlight? (yes/no)");
                } else {
                    lawnscripttimeline = 2;
                    System.out.println("No investigating today! Where to next?");
                }
            } else if (lawnscripttimeline == 3) {
                if (response == true) {
                    myUser.inventory.add(duffel);
                    myUser.inventory.add(flashlight);
                    lawnscripttimeline = 5;
                    System.out.println("Congrats, you have obtained a duffel bag and a flashlight! Where to next?");
                } else {
                    lawnscripttimeline = 4;
                    System.out.println("Okay we will leave that there. Where to next?");
                }
            } else if (lawnscripttimeline == 5) {
                System.out.println("There is nothing here. It's quite dark out. Where do you want to go next?");
            }
        } else if (myUser.location==4){
            System.out.println("What a slippery slop you've fallen down! Why would you go to the pond at night time?? You fell in :(");
            myUser.alive=false;
        } else if (myUser.location==5){
            System.out.println("Oh no! The carnivorous plants have eaten you ");
            myUser.alive=false;
        } else if (myUser.location==6){
            System.out.println("You got distracted by a poetry reading and did not complete the mission, better luck next time!");
            myUser.alive=false;
        } else if (myUser.location==7){
            System.out.println("You lost track of time talking with your friends! Never go to the Alumnae Gym to get anything done");
            myUser.alive=false;
        }
    }

            

    

    public static void main(String[] args) {
        Game myGame= new Game();
        myGame.bassscripttimeline = 0;
        myGame.burtonscripttimeline = 0;
        myGame.neilsonscripttimeline = 0;
        myGame.lawnscripttimeline = 0;

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

        //INSTRUCITONS
        System.out.println("\n");
        System.out.println("\033[3m"+"You are currently located in Bass Hall. To the North is Neilson Library. To the East is the Alumnae Gym. To the South is nothing. To the West is Burton Hall. "+"\033[0m");
        System.out.println("\n"); 
        System.out.println("Your inventory is currently empty. You can access your inventory at any time by inputting inventory. You can drop items at any time by typing drop ____. Use n, s, e, w to move. You can move anywhere at any time. Respond to the game promts with yes/no or 1/2 depending on the prompt.");
        System.out.println("\n");        
        myGame.buildingscripts("yes");
        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {

            userResponse = userInput.nextLine().toLowerCase();
            
            if (userResponse.equals("n")) {
                myGame.neilsonscripttimeline = 0;
                if (myGame.bassscripttimeline < 3) {
                    myGame.bassscripttimeline = 0;
                } if (myGame.burtonscripttimeline < 2){
                    myGame.burtonscripttimeline = 0;
                }
                myGame.myUser.move("n", myGame.map);
                myGame.script(myGame.myUser.location);
                myGame.buildingscripts("n");
            } else if (userResponse.equals("s")) {
                myGame.neilsonscripttimeline = 0;
                if (myGame.bassscripttimeline < 3) {
                    myGame.bassscripttimeline = 0;
                } if (myGame.burtonscripttimeline < 2){
                    myGame.burtonscripttimeline = 0;
                }
                myGame.myUser.move("s", myGame.map);
                myGame.script(myGame.myUser.location);
                myGame.buildingscripts("s");
            } else if (userResponse.equals("e")) {
                myGame.neilsonscripttimeline = 0;
                if (myGame.bassscripttimeline < 3) {
                    myGame.bassscripttimeline = 0;
                } if (myGame.burtonscripttimeline < 2){
                    myGame.burtonscripttimeline = 0;
                }
                myGame.myUser.move("e", myGame.map);
                myGame.script(myGame.myUser.location);
                myGame.buildingscripts("e");
            } else if (userResponse.equals("w")) {
                myGame.neilsonscripttimeline = 0;
                if (myGame.bassscripttimeline < 3) {
                    myGame.bassscripttimeline = 0;
                } if (myGame.burtonscripttimeline < 2){
                    myGame.burtonscripttimeline = 0;
                }
                myGame.myUser.move("w", myGame.map);
                myGame.script(myGame.myUser.location);
                myGame.buildingscripts("w");
            } else if (userResponse.equals("1")) {
                myGame.response = false;
                myGame.buildingscripts("1");
            } else if (userResponse.equals("2")) {
                myGame.response = true;
                myGame.buildingscripts("2");
            } else if (userResponse.equals("yes")) {
                    myGame.response = true;
                    myGame.buildingscripts("yes");
            } else if (userResponse.equals("no")) {
                    myGame.response = false;
                    myGame.buildingscripts("no");
            } else if (userResponse.contains("inventory")) {
                myGame.myUser.printInventory();
            } else if (userResponse.contains("drop")) {
                String [] words=userResponse.split("\\s");
                myGame.myUser.dropItem(myGame.myUser.findItem(words[1]));
                if (!myGame.myUser.inventory.contains(myGame.key)){
                    myGame.map.get(0).setLocked(true);
                }
            } else {
                System.out.println("We don't have that function. Please try something else.");
            } if (!myGame.myUser.alive) {

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

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        // if (userResponse.equals("WIN")) {
        //     System.out.println("Yay, you won!");
        // } else { // userResponse.equals("LOSE")
        //     System.out.println("Better luck next time.");
        // }

   // }

    }
}

