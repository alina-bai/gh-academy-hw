package org.example.week9;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean isAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.isAvailable();
            }
        }
        return false;
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Return null if the book isn't found
    }
}