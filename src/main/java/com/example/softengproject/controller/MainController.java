package com.example.softengproject.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.softengproject.entity.Product;
import com.example.softengproject.entity.ProductList;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
        String filename = "src/main/java/com/example/softengproject/data/desktops.csv";
        try {
            productList = readFile(filename);
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
/*
    private static ArrayList<Product> readFromCSVFile(String filename) throws FileNotFoundException{
        ArrayList<Product> productList = new ArrayList<Product>();
        File readFile = new File(filename);
        String absoluteFilePath = readFile.getAbsolutePath();
        String line = "";
        String splitBy = ","; 

        Integer id;
        String name;
        Type type;
        String description;
        Double price;
        Integer quantity;
        String vendor;
        Integer rating;


        try (BufferedReader reader = new BufferedReader(
                    new FileReader(absoluteFilePath))) {
            while ( (line = reader.readLine()) != null) {
                String[] product = line.split(splitBy);
                productList.add(new Product(
                            id = Integer.valueOf(product[0]), 
                            name = product[1].toString(), 
                            type = Type.valueOf(product[2]), 
                            description = product[3].toString(), 
                            price = Double.valueOf(product[4]), 
                            quantity = Integer.valueOf(product[5]), 
                            vendor = product[6].toString(),
                            rating = Integer.valueOf(product[7])
                            )
                        );
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return productList;
    } */

    private ArrayList<Product> readFile(String filename) {
        ArrayList<Product> productList = new ArrayList<Product>();
        File readFile = new File(filename);
        String absoluteFilePath = readFile.getAbsolutePath();
        String line = "";
        String splitBy = ",";  

        try {
            Scanner reader = new Scanner(readFile);
            while (reader.hasNextLine()) {
                String[] product = line.split(splitBy);
                // write code to fill array  
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File "+filename+" did NOT open");
            e.printStackTrace();
        }

        return productList;
    } 
}

