package _6_Exercises_DefiningClasses._07_Google;

public class Car {
    private String carModel;
    private String carSpeed;

    public Car(String carMode, String carSpeed) {
        this.carModel = carMode;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {

        return String.format("%s %s", this.carModel, this.carSpeed);
    }
}
