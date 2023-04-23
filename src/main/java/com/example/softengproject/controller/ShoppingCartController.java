/*
package com.example.softengproject.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.softengproject.entity.Product;
import com.example.softengproject.entity.ShoppingCart;
import com.example.softengproject.entity.Product.Type;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    ShoppingCart shoppingCart;

    Product product;

    @RequestMapping(value="/403") 
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping(value="/shopping-cart", method=RequestMethod.GET)  
    public String showShoppingCartTemplate(Model model) {
        try {
            model.addAttribute("shoppingCartProductList", loadShoppingCartProductList()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "shopping-cart";
    }

    private ArrayList<Product> loadShoppingCartProductList() throws Exception {
        ArrayList<Product> productList = new ArrayList<Product>();
        final String filename = "src/main/java/com/example/softenjproject/data/shopping-cart.csv";

        try {
            productList = readCSVFile(productList, filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList; 
    }

    /**
     * Reads product CSV files line by line and stores the info into an array of
     * Product objects
     *
     * @param filename The file name to best read
     *
     * @return An array list of Product objects with updated info
     */
/*
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
                String name = columns[1].replaceAll("\"", "");
                Type type = Type.valueOf(columns[2].replaceAll("\\s+", "").replaceAll("\"", ""));
                String description = columns[3].replaceAll("\"", "");
                Double price = Double.parseDouble(columns[4]);
                Integer quantity = Integer.parseInt(columns[5]);
                String vendor = columns[6].replaceAll("\"", "");
                Integer rating = Integer.parseInt(columns[7]);

                productList.add(new Product(id, name, type, description, price, quantity, vendor, rating));
            }

        } catch (FileNotFoundException e1) {
            System.err.println(filename + " not found");
            System.exit(0);
        } catch (IOException e2) {
            System.err.println(filename + " is not read");
        }

        return productList;
    }


    private void removeProductFromShoppingCart(Product product) {
        // write code here
    }
}
*/
