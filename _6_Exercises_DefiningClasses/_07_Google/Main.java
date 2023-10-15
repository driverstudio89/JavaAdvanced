package _6_Exercises_DefiningClasses._07_Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> personMap = new HashMap<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String command = tokens[1];

            Company company = null;
            Pokemon pokemon = null;
            Parents parents = null;
            Children children = null;
            Car car = null;

            personMap.putIfAbsent(personName, new Person(personName, company, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), car));

            switch (command) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    String salary = tokens[4];
                    company = new Company(companyName, department, salary);
                    personMap.get(personName).setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(personName).getPokemon().add(pokemon);
                    break;

                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    parents = new Parents(parentName, parentBirthday);
                    personMap.get(personName).getParents().add(parents);
                    break;

                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    children = new Children(childName, childBirthday);
                    personMap.get(personName).getChildren().add(children);
                    break;

                case "car":
                    String carModel = tokens[2];
                    String carSpeed = tokens[3];
                    car = new Car(carModel, carSpeed);
                    personMap.get(personName).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        System.out.println(input);
        for (Map.Entry<String, Person> person : personMap.entrySet()) {
            if (person.getKey().equals(input)) {

                System.out.println("Company:");
                if (person.getValue().getCompany() != null) {
                    System.out.println(person.getValue().getCompany());
                }
                System.out.println("Car:");
                if (person.getValue().getCar() != null) {
                    System.out.println(person.getValue().getCar());
                }
                System.out.println("Pokemon:");
                if (person.getValue().getPokemon() != null) {
                    person.getValue().getPokemon().forEach(System.out::println);
                }
                System.out.println("Parents:");
                if (person.getValue().getParents() != null) {
                    person.getValue().getParents().forEach(System.out::println);
                }
                System.out.println("Children:");
                if (person.getValue().getChildren() != null) {
                    person.getValue().getChildren().forEach(System.out::println);
                }
            }
        }


    }
}
