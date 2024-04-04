package oe.lab09.lab09_20240410_teachers.Model;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String address;

    public User(String username, String password, String fullName, String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
    }

    public boolean isPasswordCorrect(String pw) {
        return password.equals(pw);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }
}