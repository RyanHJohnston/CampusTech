package com.example.softengproject.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

public class User {
    

    private Integer id;

    @NotBlank(message = "User's firstName cannot be empty")
    @NotNull(message = "User's firstName cannot be NULL")
    private String firstName;

    @NotBlank(message = "User's lastName cannot be empty")
    @NotNull(message = "User's lastName cannot be NULL")
    private String lastName;

    @NotBlank(message = "User's username cannot be empty")
    @NotNull(message = "User's username cannot be empty")
    private String username; 

    @NotBlank(message = "User's email cannot be empty")
    @NotNull(message = "User's email cannot be NULL")
    private String email;

    @NotBlank(message = "User's password cannot be empty")
    @NotNull(message = "User's password cannot be NULL")
    private String password;

    public User() {}

    public User(Integer id, String firstName, String lastName, String email, String username, 
            String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Shows the order history of the user
     *
     * @param shoppingCart ShoppingCart object, supplies method with data of order
     * history
     */
    public void showOrderHistory(ShoppingCart shoppingCart) {
        try {
            shoppingCart.getProducts().toString();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Gets the User's first name
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Gets the User's last name
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Gets the User's email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the User's username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Gets the Users' password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the User's first name
     *
     * @param firstName String firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the User's last name
     *
     * @param lastName String lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Set's the User's email
     *
     * @param email String email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Sets the User's username
     *
     * @param username String username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the User's password
     *
     * @param password String password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
