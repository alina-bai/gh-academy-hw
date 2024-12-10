package org.example.week8;

import java.sql.*;
import java.util.Scanner;

public class Main {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "1234567Alin@";

    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Establish database connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully!");

            // Main Menu Loop
            showMenu();

        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Console-based interface for user interaction
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. Retrieve Data");
            System.out.println("4. Update Data");
            System.out.println("5. Delete a Record");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createTable();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    retrieveData();
                    break;
                case 4:
                    updateData();
                    break;
                case 5:
                    deleteData();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    closeConnection();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "age INT NOT NULL, " +
                    "grade DOUBLE NOT NULL)";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public static void insertData() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of records to insert: ");
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter student name: ");
                String name = scanner.next();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                System.out.print("Enter grade: ");
                double grade = scanner.nextDouble();

                String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setDouble(3, grade);

                stmt.executeUpdate();
                System.out.println("Inserted record: " + name + ", age: " + age + ", grade: " + grade);
            }

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }

    public static void retrieveData() {
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nStudent Records:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Grade: " + rs.getDouble("grade"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
    }

    public static void updateData() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID to update: ");
            int id = scanner.nextInt();
            System.out.print("Enter new grade: ");
            double newGrade = scanner.nextDouble();

            String sql = "UPDATE students SET grade = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, newGrade);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Grade updated successfully.");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }
    }

    public static void deleteData() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student ID to delete: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student record deleted successfully.");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}