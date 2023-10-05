package _3_Exercises_SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> elementsSet = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String elements : line) {
                elementsSet.add(elements);
            }
        }
        for (String element : elementsSet) {
            System.out.print(element + " ");
        }
    }
}
