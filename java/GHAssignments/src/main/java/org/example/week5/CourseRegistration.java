package org.example.week5;

import java.util.ArrayList;

// CourseRegistration.java
public class CourseRegistration {
    private ArrayList<Student> students;
    private static final int MAX_STUDENTS = 5;

    // Constructor
    public CourseRegistration() {
        students = new ArrayList<>();
    }

    // Method to register a student
    public void registerStudent(Student student) throws CourseFullException {
        if (students.size() >= MAX_STUDENTS) {
            throw new CourseFullException("The course is full. Maximum 5 students allowed.");
        }
        students.add(student);
        System.out.println(student.getName() + " has been successfully registered.");
    }

    // Method to unregister a student (bonus)
    public void unregisterStudent(String name) throws Exception {
        boolean removed = students.removeIf(student -> student.getName().equals(name));
        if (!removed) {
            throw new Exception("Student with name " + name + " is not registered.");
        }
        System.out.println(name + " has been successfully unregistered.");
    }

    // Get the list of registered students
    public ArrayList<Student> getRegisteredStudents() {
        return students;
    }
}