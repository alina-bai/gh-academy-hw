package org.example.Week4;

public class FullTimeProfessor extends Professor {
    private double monthlySalary; // Фиксированная зарплата преподавателя.

    public FullTimeProfessor(String name, Department department, double monthlySalary) {
        super(name, department); // Вызываем конструктор суперкласса Professor.
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary; // Возвращаем фиксированную зарплату.
    }

    @Override
    public void teachCourse(String courseName) {
        System.out.println(getName() + " is teaching " + courseName + " as a full-time professor.");
    }
}
