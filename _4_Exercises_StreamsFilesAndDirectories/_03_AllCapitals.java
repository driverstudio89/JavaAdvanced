package _4_Exercises_StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _03_AllCapitals {

    public static void main(String[] args) {

        String path = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String input = br.readLine();

            while (input != null) {


                writer.write(input.toUpperCase());
                writer.newLine();

                input = br.readLine();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
