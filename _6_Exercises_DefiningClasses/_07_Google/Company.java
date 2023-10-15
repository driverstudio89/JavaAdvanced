package _6_Exercises_DefiningClasses._07_Google;

public class Company {
    private String companyName;
    private String department;
    private String salary;

    public Company(String companyName, String department, String salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {

        return String.format("%s %s %.2f", this.companyName, this.department, Double.parseDouble(this.salary));
    }
}
