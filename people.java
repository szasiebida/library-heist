import java.util.ArrayList; // import the ArrayList class

public class People {

    private String name;
    private String location;
    private String items;
    private String dialogue;

    public People(String name, String location, String items, String dialogue) {
        this.name = name;
        this.location = location;
        this.items = items;
        this.dialogue = dialogue;
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