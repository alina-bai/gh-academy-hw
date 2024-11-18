package org.example.Week4;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Student> students; // Список студентов

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student); // Добавляем студента в список
    }
}