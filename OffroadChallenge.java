import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OffroadChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> fuelQuantityStack = new ArrayDeque<>();
        Deque<Integer> consumptionQueue = new ArrayDeque<>();
        Deque<Integer> fuelNeededQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(fuelQuantityStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(consumptionQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(fuelNeededQueue::offer);

        int reachedAltitudes = 0;

        for (int i = 0; i < 4; i++) {
            int fuel = fuelQuantityStack.pop();
            int consumption = consumptionQueue.poll();
            int neededFuel = fuelNeededQueue.poll();

            int availableFuel = fuel - consumption;

            if (availableFuel >= neededFuel) {
                reachedAltitudes++;
                System.out.printf("John has reached: Altitude %d%n", i + 1);
            } else {
                System.out.printf("John did not reach: Altitude %d%n", i + 1);
                break;
            }
            if (reachedAltitudes == 4) {
                break;
            }
        }

        if (fuelNeededQueue.size() > 0 && reachedAltitudes == 0) {
            System.out.println("John failed to reach the top.\n" + "John didn't reach any altitude.");
        } else if (reachedAltitudes == 4) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i <= reachedAltitudes ; i++) {
                if (i == reachedAltitudes) {
                    System.out.printf("Altitude %d", i);
                } else {
                    System.out.printf("Altitude %d, ", i);
                }
            }
        }


    }
}
