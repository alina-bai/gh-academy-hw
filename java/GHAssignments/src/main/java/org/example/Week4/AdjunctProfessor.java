package org.example.Week4;
import org.example.Week4.Department;
import org.example.Week4.Professor;

public class AdjunctProfessor extends Professor {
    private int numberOfCourses; // Количество курсов, которые ведет преподаватель.

    public AdjunctProfessor(String name, Department department, int numberOfCourses) {
        super(name, department); // Вызываем конструктор суперкласса Professor.
        this.numberOfCourses = numberOfCourses;
    }

    @Override
    public double calculateSalary() {
        return numberOfCourses * 1500; // Зарплата = $1500 * количество курсов.
    }

    @Override
    public void teachCourse(String courseName) {
        System.out.println(getName() + " is teaching " + courseName + " as an adjunct professor.");
    }
}