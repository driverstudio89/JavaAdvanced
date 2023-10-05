package _4_Exercises_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _05_LineNumbers {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String input = reader.readLine();

            int counter = 1;
            while (input != null) {
                writer.write(String.format("%d. %s%n", counter, input));
                counter++;
                input = reader.readLine();
            }




        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
