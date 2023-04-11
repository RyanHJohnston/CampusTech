package com.example.softengproject.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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

    @RequestMapping("/403") 
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String showHomeTemplate() throws Exception {
        return "home";
    }

    /*
     * This is where the data will be rendered into the Thymeleaf template
     * this method sends a GET request to render the new data from the Model
     */
    @RequestMapping(value = "/desktops", method = RequestMethod.GET)
    public String redirectToDesktopsTemplate(Model model) throws Exception {
        model.addAttribute("productList", loadProductTypeDesktopList());
        // model.addAttribute("productTypeDesktopData", "Desktop data from attribute");  
        return "desktops";
    }

    @RequestMapping(value = "/laptops", method = RequestMethod.GET)
    public String redirectToLaptopsTemplate(Model model) throws Exception {
        model.addAttribute("productTypeLaptopData", "Laptop products load here");
        return "laptops";
    } 

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public String redirectToPhonesTemplate(Model model) throws Exception {
        model.addAttribute("productTypePhonesData", "Phone products load here");
        return "phones";
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.GET)
    public String redirectToAccessoriesTemplate(Model model) throws Exception {
        model.addAttribute("productTypeAccessoriesData", "Accessory products load here");
        return "accessories";
    }

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public String redirectToShoppingCartTemplate(Model model) throws Exception {
        return "invoice";
    }

    @RequestMapping(value = "/home")
    public String redirectToAboutTemplate(Model model) throws Exception {
        return "home";
    }

    /* For each productLoad method,
     * the data will be loaded from the database,
     * in the mean time, it will just be loaded from a csv file,
     * the csv files will be primarly used for testing 
     */
    @ModelAttribute
    private ArrayList<Product> loadProductTypeDesktopList() throws Exception {
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            productList.add(new Product(
                        12345678,
                        "Lenovo 4500 XT",
                        Type.DESKTOP,
                        "Gaming PC for college students",
                        1200.00,
                        15,
                        "Lenovo Inc.",
                        4
                        )
                    ); 
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return productList;
    }
    
    
    private void loadProductTypeLaptopList() {
        // load csv file data here
    }

    private void loadProductTypePhoneList() {
        // load csv file data here
    }

    private void loadProductTypeAccessoriesList() {
        // load csv file data here
    }
}

