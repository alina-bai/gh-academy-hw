package org.example.Week4;

public class Main {
    public static void main(String[] args) {
        // Создаем кафедру
        Department csDepartment = new Department("Computer Science");

        // Создаем курсы
        Course dataStructures = new Course("Data Structures");
        Course algorithms = new Course("Algorithms");

        // Создаем профессоров
        AdjunctProfessor adjunctProfessor = new AdjunctProfessor("Ms. Laura Brown", csDepartment, 3);
        FullTimeProfessor fullTimeProfessor = new FullTimeProfessor("Dr. John Smith", csDepartment, 5000);

        // Добавляем профессоров и курсы в кафедру
        csDepartment.addProfessor(adjunctProfessor);
        csDepartment.addProfessor(fullTimeProfessor);
        csDepartment.addCourse(dataStructures);
        csDepartment.addCourse(algorithms);

        // Создаем студентов
        Student student1 = new Student("Jane Doe", 1);
        Student student2 = new Student("Mark Lee", 2);

        // Добавляем студентов на курсы
        dataStructures.addStudent(student1);
        dataStructures.addStudent(student2);
        algorithms.addStudent(student1);

        // Выводим информацию о кафедре
        System.out.println("Department: " + csDepartment.getName());
        System.out.println("Professors:");
        for (Professor professor : csDepartment.getProfessors()) {
            System.out.println("- " + professor.getName());
        }

        System.out.println("Courses:");
        for (Course course : csDepartment.getCourses()) {
            System.out.println("- " + course.getName());
            System.out.println("  Students:");
            for (Student student : course.getStudents()) {
                System.out.println("    - " + student.getName());
            }
        }
    }
}