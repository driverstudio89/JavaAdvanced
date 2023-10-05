package _4_Exercises_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class _07_MergeTwoFiles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputOnePath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputTwoPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader readerOne = Files.newBufferedReader(Path.of(inputOnePath));
             BufferedReader readerTwo = Files.newBufferedReader(Path.of(inputTwoPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String inputOne = readerOne.readLine();

            while (inputOne != null) {
                writer.write(inputOne);
                writer.newLine();

                inputOne = readerOne.readLine();
            }

            String inputTwo = readerTwo.readLine();
            while (inputTwo != null) {
                writer.write(inputTwo);
                writer.newLine();

                inputTwo = readerTwo.readLine();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
