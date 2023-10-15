package _6_Exercises_DefiningClasses._03_SpeedRacing;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPer1Km = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostPer1Km);

            carMap.putIfAbsent(model, car);
        }

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String model = tokens[1];
            int kilometers = Integer.parseInt(tokens[2]);

            Car car = carMap.get(model);

            if (car.hasSufficientFuel(kilometers)) {
                car.increaseDistanceTraveled(kilometers);
                car.decreaseFuel(kilometers);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }
        carMap.values().forEach(System.out::println);

    }
}
