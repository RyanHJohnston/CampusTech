package com.example.softengproject.Model;

import java.util.ArrayList;
import org.hibernate.annotations.NotFound;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;

@Entity
public class ShoppingCart {

  @Nonnull
  @NotFound
  private ArrayList<Product> products;

  @Nonnull
  @NotFound
  private Double totalAmount;

  @Nonnull
  @NotFound
  private Double payableAmount;

  @Nonnull
  @NotFound
  private Double tax;

  @Nonnull
  @NotFound
  private Double coupon;

  @Nonnull
  @NotFound
  private String deliveryLocation;


  public ShoppingCart() {}

  public ShoppingCart(ArrayList<Product> products, Double totalAmount,
      Double payableAmount, Double tax, Double coupon, String deliveryLocation) {
    this.products = products;
    this.totalAmount = totalAmount;
    this.payableAmount = payableAmount;
    this.tax = tax;
    this.coupon = coupon;
    this.deliveryLocation = deliveryLocation;
  }

  public void addToCart(Product product) {
    /* Write code here */
  }

  public void showChart() {
    /* Write code here */
  }

  public void removeFromCart(Product product) {
    /* Write code here */
  }

  public void applyCoupon(Double coupon) {
    /* Write code here */
  }

  public void printInvoice() {
    /* Write code here */
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public Double getPayableAmount() {
    return payableAmount;
  }

  public Double getTax() {
    return tax;
  }

  public Double getCoupon() {
    return coupon;
  }

  public String getDeliveryLocation() {
    return deliveryLocation;
  }

  public void setProducts(ArrayList<Product> products) {
    this.products = products;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public void setPayableAmount(Double payableAmount) {
    this.payableAmount = payableAmount;
  }

  public void setCoupon(Double coupon) {
    this.coupon = coupon;
  }

  public void setDeliveryLocation(String deliveryLocation) {
    this.deliveryLocation = deliveryLocation;
  }
}
