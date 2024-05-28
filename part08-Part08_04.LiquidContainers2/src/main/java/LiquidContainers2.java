
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container firstContainer = new Container();
        Container secondContainer = new Container();

        while (true) {

            System.out.println("First: " + firstContainer);
            System.out.println("Second: " + secondContainer);

            System.out.print("> ");

            String input = scan.nextLine();

            if (input.equals("quit")) {
                break;
            }

            String[] words = input.split(" ");
            String command = words[0];
            int amount = Integer.valueOf(words[1]);

            if (command.equals("add") && amount > 0) {
                firstContainer.add(amount);
            }

            if (command.equals("move") && amount > 0) {
                amount = Math.min(firstContainer.contains(), amount);
                firstContainer.remove(amount);
                secondContainer.add(amount);
            }

            if (command.equals("remove") && amount > 0) {
                secondContainer.remove(amount);
            } else {
                System.out.println("Unknown command");
            }

        }

        scan.close();
    }

}
