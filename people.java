import java.util.ArrayList; // import the ArrayList class
//just have text ?? dont need a class 

public class People {

    private String name;
    private String items;
    private String dialogue;
    int location;


    public People(String name, String items, String dialogue, int location) {
        this.name = name;
        this.items = items;
        this.dialogue = dialogue;
        this.location= location;
    }

    private void speak() {
        System.out.println(dialogue);
    }

    private void giveItem() {
        System.out.println(items + "aquired.");
    }


    public static void main(String[] args) {
        
    }
}