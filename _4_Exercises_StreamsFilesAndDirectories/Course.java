package _4_Exercises_StreamsFilesAndDirectories;

import java.io.Serializable;

public class Course implements Serializable {

    private String name;
    private int students;

    public Course(String name, int students) {

        this.name = name;
        this.students = students;
    }
}
