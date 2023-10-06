package _5_Exercises_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_PredicateForNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Predicate<String> checkLength = name -> name.length() <= n;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(checkLength)
                .forEach(System.out::println);
    }
}
