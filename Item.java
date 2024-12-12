public class Item {

    private String name;
    private String function;

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

    
    public static void main(String[] args) {
        
        Item key= new Item("key", "unlock neilson");
        key.inspectItem();
    }
}
