import java.util.Scanner;

public class LibrarySystem {

    // Static list of books related to Computer Science
    static String[] books = {
        "Introduction to Algorithms by Thomas H. Cormen",
        "Clean Code by Robert C. Martin",
        "The Pragmatic Programmer by Andrew Hunt",
        "Artificial Intelligence: A Modern Approach by Stuart Russell",
        "Computer Networks by Andrew S. Tanenbaum"
    };
    static boolean[] isBookAvailable = {true, true, true, true, true};

    // Static list of users with names and registration numbers
    static String[] userNames = {"Alice", "Bob", "Charlie"};
    static String[] userRegNos = {"CS2023001", "CS2023002", "CS2023003"};
    static String[] borrowedBooks = {null, null, null};  // To track borrowed books per user

    // Show all books
    public static void showBooks() {
        System.out.println("\nBooks Available in the Library:");
        for (int i = 0; i < books.length; i++) {
            String status = isBookAvailable[i] ? "Available" : "Borrowed";
            System.out.println((i + 1) + ". " + books[i] + " - " + status);
        }
    }

    // Show all users with registration numbers
    public static void showUsers() {
        System.out.println("\nRegistered Computer Science Students:");
        for (int i = 0; i < userNames.length; i++) {
            System.out.println((i + 1) + ". " + userNames[i] + " (Reg No: " + userRegNos[i] + ")");
        }
    }

    // Borrow a book
    public static void borrowBook(Scanner scanner) {
        showUsers();
        System.out.print("\nEnter user number: ");
        int userIndex = scanner.nextInt() - 1;

        if (borrowedBooks[userIndex] != null) {
            System.out.println(userNames[userIndex] + " has already borrowed '" + borrowedBooks[userIndex] + "'.");
            return;
        }

        showBooks();
        System.out.print("Enter book number to borrow: ");
        int bookIndex = scanner.nextInt() - 1;

        if (isBookAvailable[bookIndex]) {
            isBookAvailable[bookIndex] = false;
            borrowedBooks[userIndex] = books[bookIndex];
            System.out.println("\n" + userNames[userIndex] + " (Reg No: " + userRegNos[userIndex] + ") borrowed '" + books[bookIndex] + "'.");
        } else {
            System.out.println("\n'" + books[bookIndex] + "' is already borrowed.");
        }
    }

    // Show borrowed books by users
    public static void showBorrowedBooks() {
        System.out.println("\nBorrowed Books:");
        for (int i = 0; i < userNames.length; i++) {
            if (borrowedBooks[i] != null) {
                System.out.println(userNames[i] + " (Reg No: " + userRegNos[i] + ") borrowed '" + borrowedBooks[i] + "'");
            } else {
                System.out.println(userNames[i] + " (Reg No: " + userRegNos[i] + ") has not borrowed any books.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show all books");
            System.out.println("2. Show all users");
            System.out.println("3. Borrow a book");
            System.out.println("4. Show borrowed books");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    borrowBook(scanner);
                    break;
                case 4:
                    showBorrowedBooks();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }
}
