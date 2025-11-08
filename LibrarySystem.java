import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private boolean isIssued;

    // Parameterized constructor
    public Book(int bookID, String title, String author, double price, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.isIssued = false; // default
    }

    // Issue book
    public void issueBook() {
        if (!isIssued && quantity > 0) {
            isIssued = true;
            quantity--;
            System.out.println("Book issued successfully.");
        } else if (isIssued) {
            System.out.println("Book is already issued.");
        } else {
            System.out.println("Book not available in stock.");
        }
    }

    // Return book
    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            quantity++;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued before.");
        }
    }

    // Display details
    public void displayDetails() {
        System.out.println("\n----- Book Details -----");
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Status: " + (isIssued ? "Issued" : "Available"));
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();   

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Book Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        // Create Book object using parameterized constructor
        Book b = new Book(id, title, author, price, quantity);

        // Display details
        b.displayDetails();

        // Issue book
        System.out.println("\n>>> Issuing the book...");
        b.issueBook();
        b.displayDetails();

        // Return book
        System.out.println("\n>>> Returning the book...");
        b.returnBook();
        b.displayDetails();
    }
}
