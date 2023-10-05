package _4_Exercises_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _02_SumBytes {

    public static void main(String[] args) {

        String path = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

            String input = bf.readLine();
            long sum = 0;

            while (input != null) {
                for (char symbol : input.toCharArray()) {
                    sum += symbol;
                }

                input = bf.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
