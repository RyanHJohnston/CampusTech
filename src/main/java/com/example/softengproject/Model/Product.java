package com.example.softengproject.Model;

import java.awt.Image;
import org.hibernate.annotations.NotFound;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Nonnull
  @NotFound
  private String description;

  @Nonnull
  @NotFound
  private Double price;

  @Nonnull
  @NotFound
  private Integer quantity;

  // We'll figure out how to validate this later
  private Image iamge;

  @Nonnull
  @NotFound
  private String vendor;

  public Product() {}

  public Product(Long id, String description, Double price, Integer quantity, 
      Image image, String vendor) {
    this.id = id;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.iamge = image;
    this.vendor = vendor;
  }

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Image getIamge() {
    return iamge;
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

  public void setIamge(Image iamge) {
    this.iamge = iamge;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  @Override
  public String toString() {
    return super.toString();
  }
} 
