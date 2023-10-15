package _6_Exercises_DefiningClasses._02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    }

                    break;
                default:

                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            employees.add(employee);
        }

        Map.Entry<String, List<Employee>> highestDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    double e1AvgSalary = e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    double e2AvgSalary = e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    return Double.compare(e2AvgSalary, e1AvgSalary);
                })
                .findFirst()
                .orElse(null);

        System.out.printf("Highest Average Salary: %s%n", highestDepartment.getKey());
        highestDepartment.getValue()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
