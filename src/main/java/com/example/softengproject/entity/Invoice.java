package com.example.softengproject.entity;

import java.util.*;

import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serializable;
import java.lang.*;
import java.sql.Date;

@Data
public class Invoice implements Serializable {
    
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Date issueDate;

    private ArrayList<Product> products;
    
    private Double taxes;

    private Double discount;

    private Double totalAmount;


    private String shippingAddress;

    private String paymentMethod;

    private Date creationTimeStamp;
    
    public Invoice(){}

    public Invoice(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // write constructor code here

    public Integer id() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
