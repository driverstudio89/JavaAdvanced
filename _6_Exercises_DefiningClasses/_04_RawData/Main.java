package _6_Exercises_DefiningClasses._04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Car> carsList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            List<Tire> tiresList = new ArrayList<>();

            for (int t = 5; t < 12; t+=2) {
                Tire tire = new Tire(Double.parseDouble(tokens[t]));
                tiresList.add(tire);
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(model, engine, cargo, tiresList);

            if (!carsList.contains(car)) {
                carsList.add(car);
            }
        }

        String command = scanner.nextLine();
        if ("fragile".equals(command)) {

            carsList.stream().filter(e -> e.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> {
                        for (int i = 0; i < car.getTire().size(); i++) {
                            if (car.getTire().get(i).getTirePressure() < 1) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .forEach(e -> System.out.println(e.getModel()));


        } else if ("flamable".equals(command)){

            carsList.stream().filter(e -> e.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(e -> System.out.println(e.getModel()));

        } else {
            System.out.println("error");
        }

    }
}
