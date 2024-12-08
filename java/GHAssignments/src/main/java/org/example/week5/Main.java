package org.example.week5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseRegistration course = new CourseRegistration();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Student");
            System.out.println("2. Unregister Student (Bonus)");
            System.out.println("3. View Registered Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Register a student
                    try {
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Student student = new Student(name, age);
                        course.registerStudent(student);
                    } catch (InvalidNameException | InvalidAgeException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (CourseFullException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Unregister a student (bonus)
                    try {
                        System.out.print("Enter the name of the student to unregister: ");
                        String name = scanner.nextLine();
                        course.unregisterStudent(name);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // View registered students
                    System.out.println("Registered Students:");
                    for (Student s : course.getRegisteredStudents()) {
                        System.out.println("- " + s.getName() + ", Age: " + s.getAge());
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}