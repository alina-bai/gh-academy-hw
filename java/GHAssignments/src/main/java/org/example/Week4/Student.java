package org.example.Week4;

import java.util.HashMap;

public class Student {
    private String name;
    private int studentId;
    private HashMap<Course, Integer> grades;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new HashMap<>();
    }

    public void addGrade(Course course, int grade) {
        grades.put(course, grade);
    }

    public void printGradeReport() {
        System.out.println("Grade Report for " + name + ":");
        for (Course course : grades.keySet()) {
            System.out.println("- " + course.getName() + ": " + grades.get(course));
        }
    }

    public String getName() {
        return name;
    }
}