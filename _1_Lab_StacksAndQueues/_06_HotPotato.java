package _1_Lab_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        int tosses = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < tosses - 1; i++) {
                String player = queue.poll();
                queue.offer(player);
            }
            String removed = queue.poll();
            System.out.println("Removed " + removed);

        }
        System.out.println("Last is " + queue.poll());

    }
}
