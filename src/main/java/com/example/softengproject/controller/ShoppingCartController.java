package com.example.softengproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.softengproject.entity.Product;
import com.example.softengproject.entity.ShoppingCart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    ShoppingCart shoppingCart;

    Product product;

    
    

}
