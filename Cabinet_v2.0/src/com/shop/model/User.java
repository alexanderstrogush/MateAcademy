package com.shop.model;

import java.util.Objects;

public class User {

    private int user_id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ROLE role;

    public User(String username, String firstName, String lastName, String email, String password, String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = ROLE.valueOf(role);
    }

    public User(int user_id, String username, String firstName, String lastName, String email, String password, String role) {
        this.user_id = user_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = ROLE.valueOf(role);
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleNumber() {
        return role.ordinal();
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = ROLE.valueOf(role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, firstName, lastName, email, password, role);
    }

    @Override
    public String toString() {
        return user_id + " " +
                username + " " +
                firstName + " " +
                lastName + " " +
                email + " " +
                password + "\n";
    }

    public enum ROLE {
        ADMIN,
        USER
    }
}
