package _4_Exercises_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class _06_WordCount {
    public static void main(String[] args) {

        String inputPathWords = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputPathText = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        Map<String, Integer> wordsMap = new HashMap<>();

        try (BufferedReader wordReader = Files.newBufferedReader(Path.of(inputPathWords));
             BufferedReader textReader = Files.newBufferedReader(Path.of(inputPathText));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String wordInput = wordReader.readLine();

            while (wordInput != null) {
                String[] words = wordInput.split("\\s+");

                for (String word : words) {
//                    word = word.toLowerCase();
                    wordsMap.putIfAbsent(word, 0);

                    wordInput = wordReader.readLine();
                }
            }

                String textInput = textReader.readLine();

                while (textInput != null) {
//                    textInput = textInput.toLowerCase();

                    List<String> text = Arrays.stream(textInput.split("\\s+")).toList();
                    wordsMap.forEach((key, value) -> {
                        int counter = 0;
                        for (String word : text) {
                            if (word.equals(key)) {
                                counter++;
                            }
                        }

                        wordsMap.put(key, wordsMap.get(key) + counter);

                    });

                    textInput = textReader.readLine();
                }

                wordsMap.entrySet().stream().
                        sorted((a,b) -> b.getValue().compareTo(a.getValue())).
                        forEach(entry -> {
                            try {
                                writer.write(String.format("%s - %d%n", entry.getKey(), entry.getValue()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
