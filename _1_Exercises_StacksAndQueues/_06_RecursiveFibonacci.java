package _1_Exercises_StacksAndQueues;

import java.util.Scanner;

public class _06_RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1];

        long fibonacci = getFibonacci(n);

        System.out.println(fibonacci);


    }

    private static long getFibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return memory[n];
    }
}
