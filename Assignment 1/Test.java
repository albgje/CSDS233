// Imports
import Books_Libraries.*;

// Test class
public class Test {
    // Main method
    // Tests each class
    public static void main(String[] args) {
        System.out.println("Test Classes\n");
        System.out.println("\n---------------\nBankAccounts:\n");
        // Run testBankAccount method
        testBankAccount();
        System.out.println("\n---------------\nStudents:\n");
        // Run testStudent method
        testStudent();
        System.out.println("\n---------------\nBooks and Libraries:\n");
        // Run testLibrary method
        testLibrary();
    }

    // Tests the BankAccount class by instantiating an object and calling its methods
    public static void testBankAccount() {
        // Create a new BankAccount object
        // Pass in account number (123456) and balance (1000)
        BankAccount account = new BankAccount("123456", 1000);
        
        // Print the balance
        System.out.println(account.getBalance());

        // Deposit 500 and Withdraw 200
        account.deposit(500);
        account.withdraw(200);

        // Print the balance again to see change
        System.out.println(account.getBalance());
    }

    // Tests the Student class by instantiating an object and calling its methods
    public static void testStudent() {
        // Create a new Student object
        // Pass in name (John) and id (123456)
        Student student = new Student("John", "123456");

        // Add several grades
        student.addGrade(90);
        student.addGrade(80);
        student.addGrade(100);

        // Print the average grade
        System.out.println(student.getAverageGrade());

        // Add another grade and print the new average
        student.addGrade(70);
        System.out.println(student.getAverageGrade());
    }

    // Tests the Library class by instantiating an object and calling its methods
    public static void testLibrary() {
        // Create a new Library object
        Library library = new Library();

        // Create two Book objects
        Book book1 = new Book("Harry Potter", "J. K. Rowling", "123456");
        Book book2 = new Book("The Old Man and the Sea", "Ernest Hemingway", "987654");

        // Add the books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Print the books
        System.out.println(library.printBooks());

        // Remove a book by ISBN and print the updated list
        library.removeBook("123456");
        System.out.println(library.printBooks());
    }
}
