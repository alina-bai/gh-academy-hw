package org.example.week7;

public class Student {
    private int id;
    private String name;
    private double grade;

    // Constructor to create a new student
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters and Setters (to retrieve and update the values)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Format the student's data as a string
    @Override
    public String toString() {
        return id + "," + name + "," + grade;
    }
}

