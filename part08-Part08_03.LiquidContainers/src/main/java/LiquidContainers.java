
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {

            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");

            System.out.print("> ");

            String input = scan.nextLine();

            if (input.equals("quit")) {
                break;
            }

            String[] words = input.split(" ");
            String command = words[0];
            int amount = Integer.valueOf(words[1]);

            if (command.equals("add") && amount > 0) {
                firstContainer = Math.min(100, firstContainer + amount);
            }

            if (command.equals("move") && amount > 0) {
                amount = Math.min(firstContainer, amount);
                firstContainer = firstContainer - amount;
                secondContainer = Math.min(100, secondContainer + amount);
            }

            if (command.equals("remove") && amount > 0) {
                secondContainer = Math.max(0, secondContainer - amount);
            } else {
                System.out.println("Unknown command");
            }

        }

        scan.close();
    }

}
