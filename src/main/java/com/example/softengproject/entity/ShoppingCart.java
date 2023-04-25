package com.example.softengproject.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class ShoppingCart implements Serializable {

    @NotBlank(message = "ArrayList of Products cannot be empty")
    @NotNull(message = "ArrayList of Products cannot be NULL") 
    private ArrayList<Product> products;

    @NotBlank(message = "Product totalAmount cannot be empty")
    @NotNull(message = "Product totalAmount cannot be NULL")
    private Double totalAmount;

    @NotBlank(message = "Product payableAmount cannot be empty")
    @NotNull(message = "Product payableAmount cannot be NULL")
    private Double payableAmount;

    @NotBlank(message = "Product tax amount cannot be empty")
    @NotNull(message = "Product tax ammount cannot be NULL")
    private Double tax;

    @NotBlank(message = "Product coupon cannot be empty")
    @NotNull(message = "Product message cannot be NULL")
    private Double coupon;

    @NotBlank(message = "Product deliveryLocation cannot be empty")
    @NotNull(message = "Product deliveryLocation cannot be NULL")
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
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.products.add(product);
    }

    public void showShoppingChart() {
        this.products.toString(); 
    }

    public void removeFromCart(Product product) {
        this.products.remove(product);
    }

    public void applyCoupon(Double coupon) throws Exception {
        Double discount;    

        /* coupon percentage cannot exceed 60% nor can it be less than 0 */
        try {
            if (coupon < 0 || coupon > 0.60) {
                System.err.println("ERROR: coupon percentage");
                System.exit(1);  
            }

            setCoupon(coupon);
            discount = this.totalAmount - (this.totalAmount * coupon);
            setPayableAmount(discount);
        } catch(Exception exception) {
            exception.printStackTrace(); 
        }
    }

    public void printInvoice() {
        System.out.println(this.products.toString());
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Double getTotalAmount() {
        Double total = 0.00; 
        for (Product index : getProducts()) {
            total += index.getPrice();
        }
        return total;
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

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Integer getProductQuantityByProduct(Product product) {
        HashMap<Integer, Product> map = new HashMap<Integer, Product>(); 
        Integer quantity = 0;

        for (Product index : getProducts()) {
            map.put(index.getId(), index);
            if (index.getId().equals(product.getId())) {
                ++quantity;
            }
        }

        return quantity;
    }
    
    public Double calculateTax() {
        return getTotalAmount() * getTax();
    }
}
