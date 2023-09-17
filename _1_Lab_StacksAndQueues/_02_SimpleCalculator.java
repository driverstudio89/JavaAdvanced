package _1_Lab_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _02_SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (String e : input) {
            stack.add(e);
        }
        String operator = "";

        int num = Integer.parseInt(stack.pop());
        int sum = num;
        while (!stack.isEmpty()) {

            operator = stack.pop();

            if (operator.equals("+")) {
                int nextNum = Integer.parseInt(stack.pop());
                sum = sum + nextNum;
            } else if (operator.equals("-")) {
                int nextNum = Integer.parseInt(stack.pop());
                sum = sum - nextNum;
            }
        }
        System.out.println(sum);
    }
}
