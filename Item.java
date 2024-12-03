public class Item {

    private String name;
    private String function;

    public Item(String name, String function){
        this.name=name;
        this.function=function;
    }

    public String getName(){
        return this.name;
    }

    public String getFunction(){
        return this.function;
    }

    public void useItem(Item myitem){
        System.out.println("the" + myitem.getName()+ "has"+ myitem.getFunction());
    }
    public static void main(String[] args) {
        
    }
}
