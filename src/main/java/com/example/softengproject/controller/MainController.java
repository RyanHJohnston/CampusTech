package com.example.softengproject.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.softengproject.entity.Product;
import com.example.softengproject.entity.ProductList;
import com.example.softengproject.entity.Product.Type;

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
    
    /**
     * Loads data from desktops.csv into an ArrayList of Product objects
     *
     * @return ArrayList<Product> productList
     *
     * @throws Exception 
     */
    @ModelAttribute
    private ArrayList<Product> loadProductTypeDesktopList() throws Exception {
        ArrayList<Product> productList = new ArrayList<Product>();
        String filename = "src/main/java/com/example/softengproject/data/desktops.csv";
        try {
            productList = readCSVFile(productList, filename);
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
  

    /**
     * Reads product CSV files line by line and stores the info into an array of
     * Product objects
     *
     * @param filename The file name to best read
     *
     * @return An array list of Product objects with updated info
     */
    private ArrayList<Product> readCSVFile(ArrayList<Product> productList, String filename) {
        File readFileObj = new File(filename);
        String line = "";
        String splitBy = ",";

        try (BufferedReader reader = new BufferedReader(
                    new FileReader(readFileObj))) {
            System.out.println("Reading file: " + filename);
            reader.readLine();
            while ( (line = reader.readLine()) != null) {
                String[] columns = line.split(splitBy);
                
                Integer id = Integer.parseInt(columns[0]);
                String name = columns[1];
                Type type = Type.valueOf(columns[2].replaceAll("\\s+", "").replaceAll("\"", ""));
                String description = columns[3];
                Double price = Double.parseDouble(columns[4]);
                Integer quantity = Integer.parseInt(columns[5]);
                String vendor = columns[6];
                Integer rating = Integer.parseInt(columns[7]);
                
                productList.add(new Product(id, name, type, description, price, quantity, vendor, rating));
            }

        } catch (FileNotFoundException e1) {
            System.err.println(filename + " NOT found");
            System.exit(0);
        } catch (IOException e2) {
            System.err.println(filename + " CANNOT be read");
        }

        return productList;
    }

}

