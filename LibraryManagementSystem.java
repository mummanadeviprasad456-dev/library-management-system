import java.util.Scanner;

/**
 * Main class for the Library Management System.
 * Provides a menu-driven interface to interact with the library.
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Pre-populate some data for convenience
        library.addBook(new Book(101, "Java Programming", "John Smith"));
        library.addBook(new Book(102, "OOP Principles", "Jane Doe"));
        library.addUser(new User(1, "Alice"));
        library.addUser(new User(2, "Bob"));

        System.out.println("\n========================================");
        System.out.println("   Welcome to Library Management System   ");
        System.out.println("========================================");

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Users");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bId, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(uId, name));
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int bookIdToIssue = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    library.issueBook(bookIdToIssue, userId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int bookIdToReturn = scanner.nextInt();
                    library.returnBook(bookIdToReturn);
                    break;

                case 5:
                    library.viewBooks();
                    break;

                case 6:
                    library.viewUsers();
                    break;

                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
