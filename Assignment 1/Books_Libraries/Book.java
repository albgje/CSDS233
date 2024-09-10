// Import Packages
package Books_Libraries;

/*
 * Book.java
 * This class represents a book with a title, author, and ISBN.
 * It has a method to get the book details.
 * It also has a method to get the ISBN.
 * This class is used in the Library class.
 */
public class Book {
    // Instance Variables
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getDetails() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
