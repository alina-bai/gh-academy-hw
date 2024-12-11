package org.example.week9;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // All books start as available
    }

    public synchronized void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book \"" + title + "\" checked out.");
        } else {
            System.out.println("Book \"" + title + "\" is already checked out.");
        }
    }

    public synchronized void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book \"" + title + "\" returned.");
        } else {
            System.out.println("Book \"" + title + "\" is already in the library.");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }
}