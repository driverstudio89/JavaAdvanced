package _4_Exercises_StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class _01_SumLines {

    public static void main(String[] args) {

        String path = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader buffedReader = new BufferedReader(new FileReader(path))) {

            String input = buffedReader.readLine();

            while (input != null) {
                int sum = 0;
                for (char symbol : input.toCharArray()) {
                    sum += symbol;
                }

                System.out.println(sum);

                input = buffedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
