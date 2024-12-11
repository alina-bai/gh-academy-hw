package org.example.week9;

import java.util.Random;

public class User implements Runnable {
    private String name;
    private Library library;

    public User(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] bookTitles = {"Java Fundamentals", "Data Structures", "Algorithms in Java"};

        for (int i = 0; i < 3; i++) { // Perform 3 random actions
            int action = random.nextInt(3); // 0, 1, or 2
            String title = bookTitles[random.nextInt(bookTitles.length)];

            if (action == 0) {
                // Try to check out a book
                Book book = library.getBook(title);
                if (book != null) {
                    book.checkOut();
                }
            } else if (action == 1) {
                // Try to return a book
                Book book = library.getBook(title);
                if (book != null) {
                    book.returnBook();
                }
            } else {
                // Check availability
                System.out.println("Checking availability for \"" + title + "\": " +
                        (library.isAvailable(title) ? "Available" : "Not available"));
            }

            try {
                Thread.sleep(500); // Simulate time delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}