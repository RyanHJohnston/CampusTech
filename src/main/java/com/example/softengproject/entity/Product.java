package com.example.softengproject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Product implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public enum Type {
        DESKTOP, LAPTOP, PHONE, ACCESSORY
    }

    @NotNull(message = "Product name cannot be null")
    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @NotBlank(message = "Proudct Type cannot be empty")
    @NotNull(message = "Product Type cannot be NULL") 
    private Type type; 

    @NotBlank(message = "Product Description cannot be empty")
    @NotNull(message = "Product Description cannot be NULL")
    private String description;

    @NotBlank(message = "Product Price cannot be empty")
    @NotNull(message = "Product Price cannot be NULL") 
    private Double price;

    @NotBlank(message = "Proudct Quantity cannot be empty")
    @NotNull(message = "Product Quantity cannot be NULL")
    private Integer quantity;

    @NotBlank(message = "Product Vendor cannot be empty")
    @NotNull(message = "Product Vendor cannot be NULL")
    private String vendor;

    @NotBlank(message = "Product Rating cannot be empty")
    @NotNull(message = "Product Rating cannot be empty")
    @Min(value=1, message = "Product rating cannot be less than 1")
    @Max(value=5, message = "Product rating cannot be more than 5")
    private Integer rating;

    public Product() {}

    public Product(Integer id, String name, Type type, String description, Double price, 
            Integer quantity, String vendor, Integer rating) throws IllegalArgumentException {
        try {

            if (id.equals(null) || id.toString().length() != 8) {
                throw new IllegalArgumentException(
                        "Product ID cannot be null and can only be 8 characters");
            }

            if (name.equals(null) || name.equals("")) {
                throw new IllegalArgumentException(
                        "Product name cannot be null or empty");
            }

            if (type.equals(null)) { 
                throw new IllegalArgumentException(
                        "Product Type cannot be null or empty");
            }

            if (description.equals(null) || description.equals("")) {
                throw new IllegalArgumentException(
                        "Product description cannot be null or empty");
            }

            if (price.equals(null) || price < 0.00) {
                throw new IllegalArgumentException(
                        "Product price cannot be null or less than 0.00");
            }

            if (quantity.equals(null) || quantity < 0) {
                throw new IllegalArgumentException(
                        "Product quantity cannot be null or less than 0");
            }

            if (vendor.equals(null) || vendor.equals("")) {
                throw new IllegalArgumentException(
                        "Product vendor cannot be null or less than 0");
            }

            if (rating.equals(null) || rating < 1 || rating > 5) {
                throw new IllegalArgumentException(
                        "Product rating cannot be null, less than 1, or greater than 5");
            }
            
            this.id = id;
            this.name = name;
            this.type = type;
            this.description = description;
            this.price = price;
            this.quantity = quantity;
            this.vendor = vendor;
            this.rating = rating;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getVendor() {
        return vendor;
    }

    public Integer getRating() {
        return rating;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return super.toString();
    }

} 
