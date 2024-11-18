package org.example.Week4;

public abstract class Professor {
    private String name;
    private double salary;
    private Department department;

    public Professor(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public abstract void teachCourse(String courseName);
}
