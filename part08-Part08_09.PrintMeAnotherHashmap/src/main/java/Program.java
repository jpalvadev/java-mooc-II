
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printValues(HashMap<String, Book> hashmap) {
        for (Book currBook : hashmap.values()) {
            System.out.println(currBook);
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        for (Book currBook : hashmap.values()) {
            if (currBook.getName().contains(text)) {
                System.out.println(currBook);
            }
        }
    }
}
