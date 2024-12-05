public class Item {

    private String name;
    private String function;

    public Item(String name, String function){
        this.name=name;
        this.function=function;
    }

    /**
     * 
     * @return the name of the item
     */
    public String getName(){
        return this.name;
    }

    public String getFunction(){
        return this.function;
    }

    public void inspectItem(){
        System.out.println(this.getName()+" can be used to "+this.getFunction());
    }

    public static void main(String[] args) {
        
        Item key= new Item("key", "unlock neilson");
        key.inspectItem();
    }
}
