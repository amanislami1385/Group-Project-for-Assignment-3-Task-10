package edu.aitu.oop3.entities;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
        this.email = "user@example.com";
        this.password = "password123";
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}