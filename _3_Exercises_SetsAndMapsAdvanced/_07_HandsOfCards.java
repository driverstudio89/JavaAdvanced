package _3_Exercises_SetsAndMapsAdvanced;

import java.util.*;

public class _07_HandsOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> deck = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"JOKER".equals(input)) {

            String player = input.split(": ")[0];
            deck.putIfAbsent(player, new LinkedHashSet<>());

            String[] cardsArr = input.split(": ")[1].split(", ");
            for (String card : cardsArr) {
                deck.get(player).add(card);
            }

            input = scanner.nextLine();
        }
        deck.forEach((key, value) -> {
            int points = calculatePoints(value);
            System.out.println(key + ": " + points);
        });

    }

    private static int calculatePoints(Set<String> cards) {

        int power = 0;
        int totalPower = 0;
        for (String card : cards) {
            String cardPower = card.substring(0, card.length() - 1);
            String type = String.valueOf(card.charAt(card.length() - 1));


            if (cardPower.equals("J")) {
                power = 11;
            } else if (cardPower.equals("Q")) {
                power = 12;
            } else if (cardPower.equals("K")) {
                power = 13;
            } else if (cardPower.equals("A")) {
                power = 14;
            } else {
                power = Integer.parseInt(cardPower);
            }
            if (type.equals("S")) {
                power = power * 4;
            } else if (type.equals("H")) {
                power = power * 3;
            } else if (type.equals("D")) {
                power = power * 2;
            }
            totalPower += power;

        }
        return totalPower;
    }
}

