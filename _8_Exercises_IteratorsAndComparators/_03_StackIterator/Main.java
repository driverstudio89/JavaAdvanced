package _8_Exercises_IteratorsAndComparators._03_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StackIterator stackIterator = new StackIterator();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Push":
                    Arrays.stream(input.split("[\\s,]+")).skip(1).map(Integer::parseInt).forEach(stackIterator::push);
                    break;
                case "Pop":
                    try {
                        stackIterator.pop();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);


    }
}
