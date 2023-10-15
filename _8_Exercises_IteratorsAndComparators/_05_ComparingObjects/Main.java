package _8_Exercises_IteratorsAndComparators._05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);

            personList.add(person);

            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person personToCompare = personList.get(n - 1);
        personList.remove(personToCompare);
        int equals = 0;
        int different = 0;

        for (Person person : personList) {
            int result = personToCompare.compareTo(person);

            if (result == 0) {
                equals++;
            } else {
                different++;
            }
        }
        if (equals == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equals + 1, different, personList.size() + 1);
        }

    }
}
