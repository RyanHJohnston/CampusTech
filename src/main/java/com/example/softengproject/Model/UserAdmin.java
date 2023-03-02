package com.example.softengproject.Model;

import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import com.example.softengproject.Model.*;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAdmin {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Nonnull
  @NotFound
  private String firstName;

  @Nonnull
  @NotFound
  private String lastName;

  @Nonnull
  @NotFound
  private String email;

  @Nonnull
  @NotFound
  private String password; // We need to encrypt this somehow

  @NonNull
  @NotFound
  private Long dateOfBirth;


  public UserAdmin() {}

  public UserAdmin(String firstName, String lastName, String email, String password, Long dateOfBirth) {
    /* Validate this later (use annotations) */
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.dateOfBirth = dateOfBirth;
  }


  /**
   * Shows the order history of the user
   *
   * @param shoppingCart ShoppingCart object, supplies method with data of order
   * history
   */
  public void showOrderHistory(ShoppingCart shoppingCart) {
    /* Write code here */
  }

  public void modifyProduct(Product product) {
    /* Write code here */
  }

  public void createDiscountCode() {
    /* Write code here */
  }

  public void createSalesProduct() {
    /* Write code here */
  }

  public void modifyUser(User user) {
    /* Write code here */
  }

  // Getters and setters
  public Long getId() {
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

  public String getPassword() {
    return password;
  }

  public Long getDateOfBirth() {
    return dateOfBirth;
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

  public void setPassword(String password) {
    this.password = password;
  }

  public void setDateOfBirth(Long dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
