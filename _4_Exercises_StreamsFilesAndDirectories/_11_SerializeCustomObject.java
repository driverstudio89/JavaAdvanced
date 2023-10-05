package _4_Exercises_StreamsFilesAndDirectories;

import java.io.*;

public class _11_SerializeCustomObject {

    public static void main(String[] args) {

        Course course = new Course("Java Advanced", 250);

        String path = "C:\\Users\\Plamen\\Documents\\SoftUni\\Projects\\Java Advanced\\src\\_4_Exercises_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {


            objectOutputStream.writeObject(course);

            Course deserializedCourseObject = (Course) objectInputStream.readObject();
            System.out.println();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
