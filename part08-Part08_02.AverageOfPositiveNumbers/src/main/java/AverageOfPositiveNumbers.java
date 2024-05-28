
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());

            if (input == 0) {
                break;
            }

            if (input < 0) {
                continue;
            }

            numbers.add(input);
        }

        if (numbers.isEmpty()) {
            System.out.println("Cannot calculate the average");
        } else {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            double average = (double) sum / numbers.size();
            System.out.println(average);
        }

        scanner.close();

    }
}
