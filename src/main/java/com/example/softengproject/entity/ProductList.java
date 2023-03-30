package com.example.softengproject.entity;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductList extends ArrayDeque<Product> {
    
    private Long id;

    private Date createdAt = new Date();

    private Date placedAt = new Date();

    @NotNull(message = "List of products cannot be null") 
    private List<Product> products; 

}
