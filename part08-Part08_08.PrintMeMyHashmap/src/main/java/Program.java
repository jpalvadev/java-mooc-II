
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printKeys(HashMap<String, String> hashmap) {
        for (String currKey : hashmap.keySet()) {
            System.out.println(currKey);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String currKey : hashmap.keySet()) {
            if (currKey.contains(text)) {
                System.out.println(currKey);
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String currKey : hashmap.keySet()) {
            if (currKey.contains(text)) {
                System.out.println(hashmap.get(currKey));
            }
        }
    }

}
