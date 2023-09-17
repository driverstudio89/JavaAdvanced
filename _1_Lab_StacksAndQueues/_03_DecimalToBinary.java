package _1_Lab_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _03_DecimalToBinary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        if (decimal == 0) {
            System.out.println(0);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }
        for (Integer e : stack) {
            System.out.print(e);
        }
    }
}
