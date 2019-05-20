package com.shop.model;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String firsName;
    private String lastName;
    private String email;
    private String password;

    public User(String userName, String firsName, String lastName, String email, String password) {
        this.userName = userName;
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
