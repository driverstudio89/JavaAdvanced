package _3_Exercises_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> counterMap = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            int counter = 0;
            if (counterMap.containsKey(symbol)) {
                counter = counterMap.get(symbol);
                counterMap.put(symbol, counter + 1);
            } else {
                counterMap.put(symbol, 1);
            }
        }
        counterMap.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
