package _5_Exercises_FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _09_ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());


        Predicate<Integer> isDivisibleByAll = e -> {
            for (int i : sequence) {
                if (e % i != 0) {
                    return false;
                }
            }
            return true;
        };

        numbers.forEach(e -> {
            if (isDivisibleByAll.test(e)) {
                System.out.print(e + " ");
            }
        });

    }
}
