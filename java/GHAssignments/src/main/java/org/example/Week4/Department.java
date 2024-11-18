package org.example.Week4;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Professor> professors; // Список профессоров
    private ArrayList<Course> courses;       // Список курсов

    public Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addProfessor(Professor professor) {
        professors.add(professor); // Добавляем профессора в список
    }

    public void addCourse(Course course) {
        courses.add(course); // Добавляем курс в список
    }
}