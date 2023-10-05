package _4_Exercises_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class _04_CountCharacterTypes {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationsSet = Set.of('!', ',', '.', '?');

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String input = reader.readLine();
            int vowelsCount = 0;
            int otherSymbolsCount = 0;
            int punctuationCount = 0;

            while (input != null) {

                for (char symbol : input.toCharArray()) {
                    if (vowelsSet.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuationsSet.contains(symbol)) {
                        punctuationCount++;
                    } else if (symbol == ' ') {
                        
                    }else {
                        otherSymbolsCount++;
                    }
                }

                input = reader.readLine();
            }

            writer.write(String.format("Vowels: %d%n", vowelsCount));
            writer.write(String.format("Other symbols: %d%n", otherSymbolsCount));
            writer.write(String.format("Punctuation: %d%n", punctuationCount));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
