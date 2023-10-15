package _6_Exercises_DefiningClasses._05_CarSalesman;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> enginesList = new LinkedList<>();

        List<Car> carsList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = null;
            switch (tokens.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        String displacement = tokens[2];
                        engine = new Engine(model, power, displacement, "n/a");
                    } else {
                        String efficiency = tokens[2];
                        engine = new Engine(model, power, "n/a", efficiency);
                    }
                    break;

                default:
                    String displacement = tokens[2];
                    String efficiency = tokens[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }
            enginesList.add(engine);

        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            Engine currentEngine = null;

            for (Engine eng : enginesList) {
                if (eng.getModel().equals(tokens[1])) {
                    currentEngine = eng;
                }
            }
            Car car = null;
            switch (tokens.length) {

                case 2:
                    car = new Car(model, currentEngine);
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        String weight = tokens[2];
                        car = new Car(model, currentEngine, weight, "n/a");
                    } else {
                        String color = tokens[2];
                        car = new Car(model, currentEngine, "n/a", color);
                    }
                    break;
                default:
                    String weight = tokens[2];
                    String color = tokens[3];
                    car = new Car(model, currentEngine, weight, color);
                    break;
            }
            carsList.add(car);
        }

        carsList.forEach(System.out::println);

    }
}
