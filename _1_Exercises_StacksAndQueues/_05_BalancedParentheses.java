package _1_Exercises_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == ')') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                if (!stack.pop().equals("(")) {
                    isBalanced = false;
                }
            } else if (symbol == ']') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                if (!stack.pop().equals("[")) {
                    isBalanced = false;
                }
            } else if (symbol == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                if (!stack.pop().equals("{")) {
                    isBalanced = false;
                }
            } else {
                stack.push(input.charAt(i) + "");
            }

        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}