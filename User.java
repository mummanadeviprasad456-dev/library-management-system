/**
 * Represents a user in the library management system.
 */
public class User {
    private int userId;
    private String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return String.format("User ID: %d | Name: %s", userId, userName);
    }
}
