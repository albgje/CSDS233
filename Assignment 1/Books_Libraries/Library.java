// Import Packages
package Books_Libraries;
// Import ArrayList
import java.util.ArrayList;

/*
 * Library.java
 * This class represents a library with a collection of books.
 * It has methods to add a book, remove a book, and print all books in the library.
 * This class uses the Book class.
 */
public class Library {
    // Instance Variables
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<Book>();
    }
    
    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library (by ISBN)
    public void removeBook(String isbn) {
        // Loop through all books
        for (Book book : books) {
            // If the ISBN matches, remove the book
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                break;
            }
        }
    }

    // Method to print all books in the library
    public String printBooks() {
        String result = "";
        for (Book book : books) {
            result += book.getDetails() + "\n";
        }
        return result;
    }
}
