package _5_Exercises_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> predicate;

        List<String> guestsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (input.contains("StartsWith")) {
                predicate = s -> s.startsWith(tokens[2]);
            } else if (input.contains("EndsWith")) {
                predicate = s -> s.endsWith(tokens[2]);
            } else {
                predicate = s -> s.length() == Integer.parseInt(tokens[2]);
            }

            switch (command) {
                case "Remove":
                    guestsList.removeIf(predicate);
                    break;
                case "Double":
                    List<String> guestsToDouble = guestsList.stream()
                            .filter(predicate)
                            .collect(Collectors.toList());

                    guestsList.addAll(guestsToDouble);
                    break;
            }

            input = scanner.nextLine();
        }
        Collections.sort(guestsList);
        if (guestsList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", guestsList) + " are going to the party!");;
        }


    }
}
