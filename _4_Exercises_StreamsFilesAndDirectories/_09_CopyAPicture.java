package _4_Exercises_StreamsFilesAndDirectories;

import java.io.*;

public class _09_CopyAPicture {

    public static void main(String[] args) {

        String photoPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Screenshot 2023-10-05 154934.png";
        String outputPhotoPath = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\ScreenshotCopy.png";

        try (FileInputStream fileInputStream = new FileInputStream(photoPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPhotoPath)) {

            int oneByte = fileInputStream.read();
            while (oneByte != -1) {

                fileOutputStream.write(oneByte);

                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
