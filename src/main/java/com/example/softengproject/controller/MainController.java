package com.example.softengproject.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import com.example.softengproject.entity.Product.Type;
import com.example.softengproject.entity.Product;
import com.example.softengproject.entity.ProductList;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/* Initiates thymeleaf template (index.html) 
 * This is where we will manipulate the data in the frontend
 * We can modify the name of the controller class later
 */

/* 
 * A simple controller class must do the following:
 * Handle HTTP GET requests where the request path is /demo
 * Build a list of DemoModelAgain objects of DemoModel
 * Hand the request and the data off to a view template to be rendered as HTML
 * and sent to the request web browser
 */

@Controller
@Slf4j
@RequestMapping("/")
public class MainController {

    private ProductList productList;
    
    private Product product;
    
    public void addProductsToProductList() {   
        Product product = new Product("Gaming PC", Type.DESKTOP, "Gaming PC for sale", 
                450.00, 15, "Intel");
        ProductList productList = new ProductList();
        productList.add(product);
    }

    @RequestMapping("/403") 
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String showHomeTemplate() {
        return "home";
    }
    
    @RequestMapping(value = "/desktops") 
    public String redirectToDesktopsTemplate(Model model) {
        model.addAttribute("desktopAttribute", "test"); 
        return "desktops";
    }
    
    @GetMapping("/laptops")
    public String redirectToLaptopsTemplate(Model model) {
        model.addAttribute("laptopTimeAccessed", DateFormat.getDateInstance().toString());
        return "laptops";
    } 
    
    @RequestMapping(value = "/phones") 
    public String redirectToPhonesTemplate(Model model) {
        return "phones";
    }

    @RequestMapping(value = "/accessories")
    public String redirectToAccessoriesTemplate(Model model) {
        return "accessories";
    }

    @RequestMapping(value = "/home")
    public String redirectToAboutTemplate(Model model) {
        return "home";
    }
 

}
