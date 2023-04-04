package com.example.softengproject.entity;

import java.util.*;
import java.io.Serializable;
import java.lang.*;
import java.sql.Date;

public class Invoice implements Serializable {
    
    private Long id;

    private Date issueDate;

    private ArrayList<Product> products;
    
    private Double taxes;

    private Double discount;

    private Double totalAmount;


    private String shippingAddress;

    private String paymentMethod;

    private Date creationTimeStamp;
    
    public Invoice(){}

    // write constructor code here
}
