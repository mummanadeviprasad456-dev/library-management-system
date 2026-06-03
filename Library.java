import java.util.ArrayList;
import java.util.List;

/**
 * Manages the collection of books and users in the library.
 */
public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully: " + user.getUserName());
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Error: Book with ID " + bookId + " not found.");
            return;
        }
        if (user == null) {
            System.out.println("Error: User with ID " + userId + " not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Error: Book '" + book.getTitle() + "' is already issued.");
            return;
        }

        book.setIssued(true);
        System.out.println("Success: Book '" + book.getTitle() + "' issued to " + user.getUserName() + ".");
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Error: Book with ID " + bookId + " not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Error: Book '" + book.getTitle() + "' was not issued.");
            return;
        }

        book.setIssued(false);
        System.out.println("Success: Book '" + book.getTitle() + "' has been returned.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
        } else {
            System.out.println("\n--- Library Books ---");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            System.out.println("\n--- Registered Users ---");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) return book;
        }
        return null;
    }

    private User findUserById(int id) {
        for (User user : users) {
            if (user.getUserId() == id) return user;
        }
        return null;
    }
}
