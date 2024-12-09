import java.util.ArrayList;
import java.util.Scanner;


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
    public int bassscripttimeline;
    public boolean goupinbuilding;
    public boolean exit;

    public boolean stillPlaying; //figure out how to incorporate this with the loop logic 

    /**
     * constrcutor for the game 
     * initializes the map 
     */
    public Game(){
        this.stillPlaying=true;
        this.map=new ArrayList<Room>();
        map.add(new Room("Neilson Library", "Neilson Library", -1, -1, 1, 3, true)); // Room 0
        map.add(new Room("Bass Hall", "Bass Hall", 0, -1, -1, 2, false));        // Room 1
        map.add(new Room("Burton Hall", "Burton Hall", 3, 1, -1, -1, false)); //Room 2
        map.add(new Room("Lawn", "There is a large section of grass with adirondack chairs. It's dark out but you can see a few trees. There is a dark object on the ground behind one of those trees. It looks like a piece of clothing or a bag.", -1, 0, 2, -1, false)); //Room 3
        //map.add(new Room("Paradise Pond", "Whoops, you fell in. Goodbye.", 0, 0, 0, 0, false));
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
        if (wcoordinate == -1) {
            tothewest = "nothing";
        } else {
            tothewest = map.get(wcoordinate).getName();
        }
        System.out.println("Welcome to " + currentname + ". To the North is " + tothenorth + ". To the East is " + totheeast + ". To the South is " + tothesouth + ". To the West is " + tothewest + ".");
        if (myUser.location == 1) {
            if (bassscripttimeline == 0) {
                bassscripttimeline = 1;
                System.out.println("Upon entrance to Bass Hall, you encounter students studying quietly in the foyer area and a classroom you peek your head into. Do you want to further explore the first floor (1) or go to the second floor (2)?");
            }
            else if (bassscripttimeline == 1) {
                if (goupinbuilding == true) {
                    bassscripttimeline = 2;
                    System.out.println("There are groups of students in all the calssrooms on the second floor of Bass Hall. They are all talking loudly enough for you to hear in the hallway. You hear one of them mention campo being at Burton Hall. Do you want to go see what's going on? (y/n)");
                } else {
                    bassscripttimeline = 2;
                    System.out.println("It is eerily quiet through the rest of the first floor. Once you reach the end of the hallway, you turn back. As you are walking back to the entrance, you hear someone say that campo is currently at Burton. Do you want to go investigate?");
                }
            }
            else if (bassscripttimeline == 2) {
                if (exit == true) {
                    bassscripttimeline = 3;
                    System.out.println("You follow all the students to Burton Hall.");
                    myUser.move("w", map);
                    script(myUser.location);
                }
            }
        }
    }

    public void buildingscripts(int location) {
        if (myUser.location == 1) {
            if (bassscripttimeline == 0) {
                bassscripttimeline = 1;
                System.out.println("Upon entrance to Bass Hall, you encounter students studying quietly in the foyer area and a classroom you peek your head into. Do you want to further explore the first floor (1) or go to the second floor (2)?");
            }
            else if (bassscripttimeline == 1) {
                if (goupinbuilding == true) {
                    bassscripttimeline = 2;
                    System.out.println("There are groups of students in all the calssrooms on the second floor of Bass Hall. They are all talking loudly enough for you to hear in the hallway. You hear one of them mention campo being at Burton Hall. Do you want to go see what's going on? (y/n)");
                } else {
                    bassscripttimeline = 2;
                    System.out.println("It is eerily quiet through the rest of the first floor. Once you reach the end of the hallway, you turn back. As you are walking back to the entrance, you hear someone say that campo is currently at Burton. Do you want to go investigate? (y/n)");
                }
            } else if (bassscripttimeline == 2) {
                if (exit == true) {
                    bassscripttimeline = 3;
                    System.out.println("You follow all the students to Burton Hall.");
                    myUser.move("w", map);
                    script(myUser.location);
                } else {
                    System.out.println("You get trampled by the students going to investigate campo's appearance. Restart game?");
                }
            } else if (bassscripttimeline == 3) {
                script(myUser.location);
                System.out.println("Nothing has changed in Bass Hall. It is still quiet and students are still studying. Where do you want to go next?");
            }
        }
        else if(myUser.location == 0){
            System.out.println("You made it to the library! It's pitch black and you can't see anything. Do you use you have a flashlight to use? (1) or will you continue in the dark? (2)");
            if  (user input == 1 && myUser.inventory.contains("flashlight")){
                System.out.println("Good work! You are in the front foyer of Neilson, do you take the elevator (1) or the stairs");
                    if (user input == 1){
                        System.out.println("In the elevator you have met a ghost-");
                        System.out.println("Hello there! I didn't know they let humans in after dark- would you like to take a rest with me these books are making me awfully sleepy (1) or no (2)");
                            if(userinput == 1){
                                System.out.println("you died!");
                                myUser.alive=false;}
                            else if(user input==2){
                                System.out.println("The ghost lets out a sob and mysteriously floats away");
                                System.out.println("ding! You have made it to the third floor!!");
                                System.out.println("The doors open- to your right is a closed room and to your left is the classics room where do you want to go? closed room(1) or classics room(2)");
                                    if(user input==1){
                                        System.out.println("Good choice! you found the classics room!");
                                        System.out.println("The rare books collection is sitting in front of you do you want to put it in your duffel (1) or leave(2)");
                                            if(user input==1 && myUser.inventory.contains("duffel")){
                                                System.out.println("you win!");
                                                //end loop
                                            } else if (! myUser.inventory.contains("duffel")){
                                                System.out.println("you need a duffel!");
                                                System.out.println("well put you back at the begginngin try again");
                                            } else {
                                                System.out.println("you have a strong moral compass");
                                            }
                        


                                    }else if(user input==2){
                                        System.out.println("The classics room looks awfully creepy at night do you want to go back the way you came(1) or stay here(2)");
                                    }
                            }

                            }
                    }
            } else{
                System.out.println("you died!");
                myUser.alive=false; 
            }
        }
    

    public static void main(String[] args) {
        Game myGame= new Game();
        myGame.bassscripttimeline = 0;
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
        myGame.buildingscripts(1);
        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {

            userResponse = userInput.nextLine().toLowerCase();

            if (userResponse.equals("n")) {
                myGame.myUser.move("n", myGame.map);
                myGame.buildingscripts(myGame.myUser.location);
            } else if (userResponse.equals("s")) {
                myGame.myUser.move("s", myGame.map);
                myGame.buildingscripts(myGame.myUser.location);
            } else if (userResponse.equals("e")) {
                myGame.myUser.move("e", myGame.map);
                myGame.buildingscripts(myGame.myUser.location);
            } else if (userResponse.equals("w")) {
                myGame.myUser.move("w", myGame.map);
                myGame.buildingscripts(myGame.myUser.location);
            } else if (userResponse.equals("1")) {
                myGame.goupinbuilding = false;
                myGame.buildingscripts(myGame.myUser.location);
            } else if (userResponse.equals("2")) {
                myGame.goupinbuilding = true;
                myGame.buildingscripts(myGame.myUser.location);
            } else if (userResponse.equals("y")) {
                myGame.exit = true;
                myGame.buildingscripts(myGame.myUser.location);
            } else if (userResponse.equals("n")) {
                myGame.exit = false;
                myGame.buildingscripts(myGame.myUser.location);
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

   //somewhere need to have the line if myUser.alive=false --> end game loop
    }
}


//private int plotState; // Tracks the current stage in the plot


// private int handlePlotChoices(String command, int plotState) {
//     if (plotState == 1) {
//         if (command.equals("1")) {
//             System.out.println("You chose to explore the first floor further. It's eerily quiet.");
//             plotState = 2; // Move to the next state
//         } else if (command.equals("2")) {
//             System.out.println("You ascend to the second floor. Students are chatting loudly.");
//             plotState = 3; // Different state
//         } else {
//             System.out.println("Invalid choice. Please choose 1 or 2.");
//         }
//     } else if (plotState == 2) {
//         System.out.println("You continue exploring the first floor, but it's uneventful.");
//         plotState = 0; // End this branch of the plot
//     } else if (plotState == 3) {
//         System.out.println("You hear someone mentioning campo at Burton Hall. Do you go investigate? (y/n)");
//         if (command.equals("y")) {
//             System.out.println("You head towards Burton Hall.");
//             myUser.move("w", map);
//             plotState = 0; // Reset the plot for the next event
//         } else if (command.equals("n")) {
//             System.out.println("You stay on the second floor.");
//             plotState = 0; // Reset the plot
//         } else {
//             System.out.println("Invalid choice. Please choose y or n.");
//         }
//     }
//      return plotState 
// }



// private void describeCurrentRoom() {
//     Room currentRoom = map.get(myUser.getLocation());
//     System.out.println("You are in " + currentRoom.getName() + ". " + currentRoom.getDescription());

//     if (myUser.getLocation() == 1 && plotState == 0) { // Bass Hall plot trigger
//         System.out.println("Do you want to explore the first floor (1) or go to the second floor (2)?");
//         plotState = 1; // Set the plot state
//     }
// }


