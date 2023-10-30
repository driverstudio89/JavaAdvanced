package _1_1_Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> fuelQuantityStack = new ArrayDeque<>();
        Deque<Integer> consumptionQueue = new ArrayDeque<>();
        Deque<Integer> fuelNeededQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(fuelQuantityStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(consumptionQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(fuelNeededQueue::offer);
        int counter = 0;

        while (!fuelQuantityStack.isEmpty()) {
            int fuel = fuelQuantityStack.pop();
            int consumption = consumptionQueue.poll();
            int neededFuel = fuelNeededQueue.poll();

            int availableFuel = fuel - consumption;

            if (availableFuel >= neededFuel) {
                counter++;
                System.out.printf("John has reached: Altitude %d%n", counter);
            } else {
                System.out.printf("John did not reach: Altitude %d%n", counter + 1);
                break;
            }

        }

        if (!fuelQuantityStack.isEmpty() && counter == 0) {
            System.out.printf("John failed to reach the top.%n" +
                    "John didn't reach any altitude.");
        } else if (!fuelQuantityStack.isEmpty() && counter >= 1) {
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i <= counter ; i++) {
                if (i == counter) {
                    System.out.printf("Altitude %d", i);
                } else {
                    System.out.printf("Altitude %d, ", i);
                }
            }
        } else if (fuelQuantityStack.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }

    }
}
