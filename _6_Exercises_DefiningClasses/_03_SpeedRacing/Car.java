package _6_Exercises_DefiningClasses._03_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPer1Km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPer1Km) {

        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
        this.distanceTraveled = 0;
    }

    public boolean hasSufficientFuel(int kilometers) {
        return fuelAmount >= neededFuel(kilometers);
    }

    public void decreaseFuel(int kilometers) {
        fuelAmount -= neededFuel(kilometers);
    }

    public void increaseDistanceTraveled(int kilometers) {
        this.distanceTraveled += kilometers;
    }

    @Override
    public String toString() {

        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

    private double neededFuel(int kilometers) {
        return this.fuelCostPer1Km * kilometers;
    }


}
