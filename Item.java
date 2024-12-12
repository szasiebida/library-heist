public class Item {

    private String name;
    private String function;

    /**
     * constructor for items 
     * @param name the name of the item 
     * @param function the function of the item in the game 
     */
    public Item(String name, String function){
        this.name=name;
        this.function=function;
    }

    /**
     * function to return the name of the function 
     * @return the name of the item
     */
    public String getName(){
        return this.name;
    }

    /**
     * function that returns the function of the item 
     * @return the function of the item
     */
    public String getFunction(){
        return this.function;
    }

    /**
     * function that prints both the name and the function of the item
     */
    public void inspectItem(){
        System.out.println(this.getName()+" can be used to "+this.getFunction());
    }

    //main function used for testing 
    public static void main(String[] args) {
        
        Item key= new Item("key", "unlock neilson");
        key.inspectItem();
    }
}
