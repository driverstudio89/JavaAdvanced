package _5_Exercises_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisible = number -> number % n == 0;
        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.println(e + " "));


        numbers.removeIf(isDivisible);
        Collections.reverse(numbers);

        print.accept(numbers);




    }
}
