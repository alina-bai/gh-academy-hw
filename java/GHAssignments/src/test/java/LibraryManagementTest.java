import org.example.Week3.LibraryManagementSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryManagementTest {
    public LibraryManagementSystem library; // Correct the type to LibraryManagementSystem

    @BeforeEach
    void setUp() {
        library = new LibraryManagementSystem(); // Create an instance of LibraryManagementSystem
        library.addBook("Harry Potter", 2);
        library.addBook("The Lord of the Rings", 1);
    }

    @Test
    void testAddBook() {
        library.addBook("The Hobbit", 3);
        // Assertion to check if the book was added successfully
       // assertEquals(3, library.availability.get("The Hobbit"), "The Hobbit should have 3 copies available.");
    }
}