package _1_Exercises_StacksAndQueues;

import java.util.*;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < commands[0]; i++) {
            queue.offer(input[i]);
        }
        for (int i = 0; i < commands[1]; i++) {
            queue.poll();
        }
        if (queue.contains(commands[2])) {
            System.out.println(true);
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
