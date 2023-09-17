package _1_Lab_StacksAndQueues;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> queue = new PriorityQueue<>();

        String[] input = scanner.nextLine().split("\\s+");

        int tosses = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 0; i < tosses; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
