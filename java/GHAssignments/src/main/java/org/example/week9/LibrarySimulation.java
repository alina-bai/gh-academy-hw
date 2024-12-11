package org.example.week9;

public class LibrarySimulation {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book(1, "Java Fundamentals", "Author A"));
        library.addBook(new Book(2, "Data Structures", "Author B"));
        library.addBook(new Book(3, "Algorithms in Java", "Author C"));

        // Create user threads
        Thread user1 = new Thread(new User("User 1", library));
        Thread user2 = new Thread(new User("User 2", library));
        Thread user3 = new Thread(new User("User 3", library));

        // Start threads
        user1.start();
        user2.start();
        user3.start();

        // Wait for all threads to finish
        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final list of available books
        library.displayAvailableBooks();
    }
}