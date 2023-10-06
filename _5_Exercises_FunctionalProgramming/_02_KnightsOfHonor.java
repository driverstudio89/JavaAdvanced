package _5_Exercises_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<String> toSir = s -> System.out.printf("Sir %s%n", s);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(toSir);


    }
}
