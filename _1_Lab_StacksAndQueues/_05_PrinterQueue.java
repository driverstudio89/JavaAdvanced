package _1_Lab_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_PrinterQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                queue.offer(input);
            }

            input = scanner.nextLine();
        }
        for (String e : queue) {
            System.out.println(queue.poll());
        }

    }
}
