package _07_Exercises_Generics._01_GenericBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> boxList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Box<Double> box = new Box<>(Double.parseDouble(scanner.nextLine()));
            boxList.add(box);
        }

//        int[] command = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        swapBoxes(command, boxList);
        Box<Double> stringBox = new Box<>(Double.parseDouble(scanner.nextLine()));

        int count = greaterCounter(boxList, stringBox);

        System.out.println(count);



//        boxList.forEach(System.out::println);
    }

    static <T extends Comparable<T>> int greaterCounter(List<T> data, T element) {

        int count = 0;
        for (T e : data) {
            int result = e.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }

//    private static<T> void swapBoxes(int[] command, List<T> boxList) {
//        T firstElement = boxList.get(command[0]);
//        T secondElement = boxList.get(command[1]);
//
//        boxList.set(command[0], secondElement);
//        boxList.set(command[1], firstElement);
//    }
}
