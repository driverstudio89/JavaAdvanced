package _4_Exercises_StreamsFilesAndDirectories;

import java.io.File;

public class _08_GetFolderSize {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(folderPath);

        int size = 0;

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (!file.isDirectory()) {
                    size += file.length();
                }
            }
        }

        System.out.printf("Folder size: %d", size);
    }
}
