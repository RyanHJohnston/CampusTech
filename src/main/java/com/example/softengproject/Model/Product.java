package com.example.softengproject.Model;

import java.awt.Image;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
  
  public enum Type {
    DESKTOP, LAPTOP, PHONE, ACCESSORY
  }

  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @NotBlank(message = "Proudct Type cannot be empty")
  @NotNull(message = "Product Type cannot be NULL") 
  private String type; 
  
  @NotBlank(message = "Product Description cannot be empty")
  @NotNull(message = "Product Description cannot be NULL")
  private String description;
  
  @NotBlank(message = "Product Price cannot be empty")
  @NotNull(message = "Product Price cannot be NULL") 
  private Double price;

  @NotBlank(message = "Proudct Quantity cannot be empty")
  @NotNull(message = "Product Quantity cannot be NULL")
  private Integer quantity;

  // We'll figure out how to validate this later
  private Image image;
  
  @NotBlank(message = "Product Vendor cannot be empty")
  @NotNull(message = "Product Vendor cannot be NULL")
  private String vendor;

  public Product() {}

  public Product(Long id, String description, Double price, Integer quantity, 
      Image image, String vendor) {
    this.id = id;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.image = image;
    this.vendor = vendor;
  }

  public Long getId() {
    return id;
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

  public Image getImage() {
    return image;
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

  public void setImage(Image image) {
    this.image = image;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  @Override
  public String toString() {
    return super.toString();
  }

} 
