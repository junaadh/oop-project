package oopits;

public class User {
    public String firstName, lastName, userName, password;

    public User(String[] parts) {
        firstName = parts[0];
        lastName = parts[1];
        userName = parts[2];
        password = parts[3];
    }
}
