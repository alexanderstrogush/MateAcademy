package hw07.model;

import java.io.Serializable;

public class Human implements Serializable {

    private String name;
    private String surName;
    private int age;
    private String currentCity;
    private String email;
    private String phoneNumber;

    public Human(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Human(String name, String surName, int age, String currentCity, String email, String phoneNumber) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.currentCity = currentCity;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name + " " + surName;
    }

    @Override
    public String toString() {
        return name + " " + surName +
                "{ age=" + age +
                ", currentCity='" + currentCity + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
