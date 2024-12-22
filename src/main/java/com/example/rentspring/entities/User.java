package com.example.rentspring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String fullName;
    private String city;
    private String country;
    private String username;
    private String password;
    private String birthDate;
    private String email;
    private int rating;
    private boolean isBlocked;

    public User(int userId, String fullName, String city, String country, String username, String password, String birthDate, String email, int rating, boolean isBlocked) {
        this.userId = userId;
        this.fullName = fullName;
        this.city = city;
        this.country = country;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
        this.rating = rating;
        this.isBlocked = isBlocked;
    }

    public User() {

    }

    public void setUserId(int id) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public int getRating() {
        return rating;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
