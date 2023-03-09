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
import lombok.Data;

@Entity
@Data // SUPER IMPORTANT, it generates helper methods during runtime!!! 
public class User {

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


  public User() {}

  public User(String firstName, String lastName, String email, String password, Long dateOfBirth) {
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

}
