package _1_ExamPreparation._1_Meeting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> maleStack = new ArrayDeque<>();
        Deque<Integer> femaleQueue = new ArrayDeque<>();

        int matches = 0;

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(maleStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(femaleQueue::offer);

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();

            if (male <= 0) {
                maleStack.pop();
                continue;
            }
            if (female <= 0) {
                femaleQueue.poll();
                continue;
            }

            if (female % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                if (maleStack.isEmpty() || femaleQueue.isEmpty()) {
                    break;
                }
                continue;
            }

            if (male % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                if (maleStack.isEmpty() || femaleQueue.isEmpty()) {
                    break;
                }
                continue;
            }

            if (female == male) {
                matches++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                male = maleStack.pop();
                male -= 2;
                if (male > 0) {
                    maleStack.push(male);
                }
            }

        }


        System.out.printf("Matches: %d%n", matches);
        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(String.join(", ", String.valueOf(maleStack).replaceAll("[\\[\\]]", "")));

        }
        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(String.join(", ", String.valueOf(femaleQueue).replaceAll("[\\[\\]]", "")));


        }


    }
}
