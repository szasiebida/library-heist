public class Room {

    private int n;
    private int s;
    private int e;
    private int w;
    private String name;
    private String description;
    private boolean locked;


    //a value of -1 will indicate a dead end, no room in that direction

    /**
     * constructor for the room class
     * @param name name of the room
     * @param description decription of what the room is
     * @param n represents the index of the room that is north
     * @param s represents the index of the room that is south
     * @param e represents the index of the room that is east
     * @param w represents the index of the room that is west
     */
    public Room(String name, String description, int n, int e, int s, int w, boolean locked){
        this.name=name;
        this.description=description;
        this.n=n;
        this.s=s;
        this.e=e;
        this.w=w;
        this.locked=locked;

    }

    /**
     * getter for north integer
     * @return the integer related room that is north
     */
    public int getN(){
        return this.n;
    }

    /**
     * getter for south integer
     * @return the integer related room that is south
     */
    public int getS(){
        return this.s;
    }

    /**
     * getter for east integer
     * @return the integer related room that is east
     */
    public int getE(){
        return this.e;
    }

    /**
     * getter for west integer
     * @return the integer related room that is west
     */
    public int getW(){
        return this.w;
    }

    /**
     * getter for name of the room
     * @return the name of the room
     */
    public String getName(){
        return this.name;
    }

    /**
     * getter for description of the room
     * @return the description of the room
     */
    public String getDescription(){
        return this.description;
    }

    public boolean islocked(){
        return this.locked;
    }



    public static void main(String[] args) {
        
    }
}

