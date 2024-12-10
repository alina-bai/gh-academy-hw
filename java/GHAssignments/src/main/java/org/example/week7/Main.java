package org.example.week7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Method to save students to a file
    public static void saveStudentsToFile(String filePath, List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine(); // Write each student on a new line
            }
        }
    }

    // Method to load students from a file
    public static List<Student> loadStudentsFromFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split the line by commas
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double grade = Double.parseDouble(parts[2]);
                students.add(new Student(id, name, grade));
            }
        }
        return students;
    }

    // Method to display students
    public static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Grade: " + student.getGrade());
        }
    }

    // Method to update a student's grade
    public static void updateGrade(int id, double newGrade, String filePath) throws IOException {
        // Load existing students
        List<Student> students = loadStudentsFromFile(filePath);

        // Find and update the student
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(newGrade);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        // Save the updated list back to the file
        saveStudentsToFile(filePath, students);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        String filePath = "students.txt";

        try {
            // Step 1: Add Sample Data
            List<Student> students = new ArrayList<>();
            students.add(new Student(101, "John Doe", 88.5));
            students.add(new Student(102, "Jane Smith", 92.0));
            students.add(new Student(103, "Emily White", 76.3));
            saveStudentsToFile(filePath, students);

            // Step 2: Display Data
            System.out.println("Initial Data:");
            List<Student> loadedStudents = loadStudentsFromFile(filePath);
            displayStudents(loadedStudents);

            // Step 3: Update a Grade
            updateGrade(102, 95.0, filePath);

            // Step 4: Display Updated Data
            System.out.println("\nAfter Grade Update:");
            loadedStudents = loadStudentsFromFile(filePath);
            displayStudents(loadedStudents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}