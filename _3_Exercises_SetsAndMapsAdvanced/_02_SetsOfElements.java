package _3_Exercises_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        String tokens = scanner.nextLine();
        int n = Integer.parseInt(tokens.split("\\s+")[0]);
        int m = Integer.parseInt(tokens.split("\\s+")[1]);

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        if (firstSet.size() > secondSet.size()) {
            for (Integer secondNum : secondSet) {
                for (Integer firstNum : firstSet) {
                    if (firstNum == secondNum) {
                        System.out.print(firstNum + " ");
                    }
                }
            }
        } else for (Integer firstNum : firstSet) {
            for (Integer secondNum : secondSet) {
                if (firstNum == secondNum) {
                    System.out.print(firstNum + " ");
                }
            }
        }

    }
}
