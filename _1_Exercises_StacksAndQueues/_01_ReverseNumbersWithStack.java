package _1_Exercises_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_ReverseNumbersWithStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        int[] numArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numArr.length; i++) {
            stack.push(numArr[i]);
        }
        for (Integer integer : stack) {
            System.out.print(stack.pop() + " ");
        }


    }
}
