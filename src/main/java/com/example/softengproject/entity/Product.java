package com.example.softengproject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    private Date placedAt = new Date();

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

    public Product() {}

    public Product(String name, Type type, String description, Double price, Integer quantity, 
            String vendor) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.vendor = vendor;
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

    public void setId(Long id) {
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
