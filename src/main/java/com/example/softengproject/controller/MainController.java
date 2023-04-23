package com.example.softengproject.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.softengproject.entity.Product;
import com.example.softengproject.entity.ShoppingCart;
import com.example.softengproject.entity.Product.Type;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    Product product;

    public ShoppingCart shoppingCart;
    
    @PostConstruct
    public void initialize() throws Exception {
        this.shoppingCart = new ShoppingCart(loadShoppingCartProductList(), 0.00, 0.00, 0.00, 0.00, "null");
    }

    @RequestMapping("/403") 
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String showHomeTemplate() throws Exception {
        return "home";
    }

    /*
     * Fetch index of item
     * Get the values from the item
     * Add the product object to array list of products in shopping cart class
     * Populate csv file with product data
     * Load shopping-cart.html with shopping-cart.csv data
     * Subtract 1 from product quantity in desktops.html
     * Give notification that item has been added to cart
     */
    @RequestMapping(value={"/desktops", "/laptops", "/phones", "/accessories"}, method=RequestMethod.POST)
    public String addProductToShoppingCart(
            @ModelAttribute Product productDTO, Model model, 
            final RedirectAttributes redirectAttributes) throws Exception { 
        
        ArrayList<Product> loadProductList = new ArrayList<Product>();
        String redirectPage = "";

        System.out.println("\nAdding product to cart: \n\n"
                + "ID: " + productDTO.getId() + "\n"
                + "Name: " + productDTO.getName() + "\n"
                + "Type: " + productDTO.getType() + "\n"
                + "Description: " + productDTO.getDescription() + "\n"
                + "Price: " + productDTO.getPrice() + "\n"
                + "Quantity: " + productDTO.getQuantity() + "\n"
                + "Vendor: " + productDTO.getVendor() + "\n"
                + "Rating: " + productDTO.getRating() + "/5\n");

        switch (productDTO.getType().toString()) {
            case "DESKTOP":
                redirectPage = "desktops";
                loadProductList = loadProductTypeDesktopList();
                break;
            case "LAPTOP":
                redirectPage = "laptops";
                loadProductList = loadProductTypeLaptopList(); 
                break;
            case "PHONE":
                redirectPage = "phones";
                loadProductList = loadProductTypePhoneList();
                break;
            case "ACCESSORY":
                redirectPage = "accessories";
                loadProductList = loadProductTypeAccessoriesList();
                break;
            default:
                System.err.println("\nERROR: Product TYPE could not be determined in MainController\n\n");
                break;
            }

        System.out.println("Product of type "+productDTO.getType().toString()); 
        
        this.shoppingCart.getProducts().add(productDTO);
        redirectAttributes.addFlashAttribute(productDTO);
        model.addAttribute("productList", loadProductList);
        model.addAttribute("productDTO", product);
        model.addAttribute("shoppingCartTotalPrice", Double.toString(Math.round(this.shoppingCart.getTotalAmount())));
        model.addAttribute("shoppingCartProductListQuantity", Integer.toString(this.shoppingCart.getProducts().size()));

        appendShoppingCartCSV(productDTO);

        return redirectPage;
    }

    @RequestMapping(value="/shopping-cart", method=RequestMethod.POST) 
    public String removeProductFromShopping(
            @ModelAttribute Product productRemoved, Model model,
            final RedirectAttributes redirectAttributes) throws Exception {

        System.out.println("\nRemoving "+productRemoved.getId()+" from shopping cart.\n");
        
        this.shoppingCart.getProducts().remove(productRemoved);
        redirectAttributes.addFlashAttribute(productRemoved);
        model.addAttribute("productRemoved", productRemoved);
        removeProductFromShoppingCartCSV(productRemoved);
        model.addAttribute("shoppingCartTotalPrice", this.shoppingCart.getTotalAmount().toString());
        model.addAttribute("shoppingCartProductListQuantity", Integer.toString(this.shoppingCart.getProducts().size()));
        model.addAttribute("shoppingCartProductList", loadShoppingCartProductList());
        return "shopping-cart";
            }

    /*
     * This is where the data will be rendered into the Thymeleaf template
     * this method sends a GET request to render the new data from the Model
     */
    /*
    @RequestMapping(value = "/desktops", method = RequestMethod.GET)
    public String showDesktopTemplate(Model model) throws Exception {
        model.addAttribute("productList", loadProductTypeDesktopList());
        model.addAttribute("productDTO", product); 
        return "desktops";
    }
*/
//New
@RequestMapping(value = "/desktops", method = RequestMethod.GET)
public String showDesktopTemplate(Model model, @RequestParam(name="searchTerm", required=false) String searchTerm) throws Exception {
    ArrayList<Product> productList = loadProductTypeDesktopList();

    if (searchTerm != null && !searchTerm.isEmpty()) {
        List<Product> searchResults = searchProductList(productList, searchTerm);
        model.addAttribute("productList", searchResults);
        model.addAttribute("productDTO", product);
    }
    else{
        
        model.addAttribute("productList", productList);
        model.addAttribute("productDTO", product); 
    }
    
    return "desktops";
}

/* Searches through Product List if search button is enabled */
private List<Product> searchProductList(ArrayList<Product> productList, String searchTerm) {
    List<Product> searchResults = new ArrayList<>();
    for (Product product : productList) {
        if (product.getName().toLowerCase().contains(searchTerm.toLowerCase()) || 
        product.getDescription().toLowerCase().contains(searchTerm.toLowerCase()) || 
        product.getVendor().toLowerCase().contains(searchTerm.toLowerCase())) 
        {
            searchResults.add(product);
        }
    
    }
    return searchResults;
}
    


    @RequestMapping(value = "/laptops", method = RequestMethod.GET)
    public String showLaptopTemplate(Model model) throws Exception {
        model.addAttribute("productList", "Laptop products load here");
        return "laptops";
    } 

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public String showPhoneTemplate(Model model) throws Exception {
        model.addAttribute("productList", "Phone products load here");
        return "phones";
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.GET)
    public String showAccessoriesTemplate(Model model) throws Exception {
        model.addAttribute("productList", "Accessory products load here");
        return "accessories";
    }

    @RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
    public String showShoppingCartTemplate(Model model) throws Exception {
        model.addAttribute("shoppingCartProductList", loadShoppingCartProductList());
        model.addAttribute("productRemoved", product);
        
        model.addAttribute("shoppingCartTotalPrice", Double.toString(Math.round(this.shoppingCart.getTotalAmount())));
        model.addAttribute("shoppingCartProductListQuantity", Integer.toString(this.shoppingCart.getProducts().size()));
        return "shopping-cart";
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

    @ModelAttribute
    private ArrayList<Product> loadProductTypeLaptopList() throws Exception {
        ArrayList<Product> productList = new ArrayList<Product>();
        String filename = "src/main/java/com/example/softengproject/data/laptops.csv";
        try {
            productList = readCSVFile(productList, filename);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return productList;
    }

    @ModelAttribute
    private ArrayList<Product> loadProductTypePhoneList() throws Exception{
        ArrayList<Product> productList = new ArrayList<Product>();
        String filename = "src/main/java/com/example/softengproject/data/phones.csv";
        try {
            productList = readCSVFile(productList, filename);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return productList;
    }

    @ModelAttribute
    private ArrayList<Product> loadProductTypeAccessoriesList() throws Exception{
        ArrayList<Product> productList = new ArrayList<Product>();
        String filename = "src/main/java/com/example/softengproject/data/accessories.csv";
        try {
            productList = readCSVFile(productList, filename);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return productList;
    }

    @ModelAttribute
    private ArrayList<Product> loadShoppingCartProductList() throws Exception {
        ArrayList<Product> productList = new ArrayList<Product>();
        final String filename = "src/main/java/com/example/softengproject/data/shopping-cart.csv";
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
    private ArrayList<Product> readCSVFile(ArrayList<Product> productList, String filename) {
        File readFileObj = new File(filename);
        String line = "";
        String splitBy = ",";

        try (BufferedReader reader = new BufferedReader(
                    new FileReader(readFileObj))) {
            System.out.println("Reading file: " + filename);
            // reader.readLine();
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
            // e1.printStackTrace();
            System.err.println("\n" + filename + " not found\n");
            System.out.println(new File(".").getAbsoluteFile());
            System.exit(0);
        } catch (IOException e2) {
            e2.printStackTrace();
            System.err.println(filename + " is not read");
        }

        return productList;
    }

    /**
     * Appends shopping-cart.csv with Product data
     *
     * @param product Product object
     *
     * @throws IOException Input/Output exception
     */
    private void appendShoppingCartCSV(Product product) 
            throws IOException {

            final String filename = "src/main/java/com/example/softengproject/data/shopping-cart.csv";
            try {
                FileWriter fileWriter = new FileWriter(filename, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                System.out.println("\nAppending shopping-cart.csv...\n\n");

                bufferedWriter.write(
                        product.getId().toString() + "," +
                        "\"" + product.getName() + "\"" + "," +
                        "\"" + product.getType().toString() + "\"" + "," + 
                        product.getDescription() + "," +
                        product.getPrice().toString() + "," +
                        product.getQuantity().toString() + "," +
                        "\"" + product.getVendor() + "\"" + "," +
                        product.getRating().toString() + "\n");

                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void removeProductFromShoppingCartCSV(Product product) throws IOException {

        final String filename = "src/main/java/com/example/softengproject/data/shopping-cart.csv";
        final String filenameTemp = "src/main/java/com/example/softengproject/data/shopping-cart-temp.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filenameTemp));
            StringBuilder sb = new StringBuilder();

            String productToRemove = product.getId().toString();
            String currentLine = "";
            String splitBy = ",";

            System.out.println("\nAbout to read shopping-cart.csv\n\n");

            while ( (currentLine = reader.readLine()) != null) {
                // trim newline when comparing with productToRemove
                String[] columns = currentLine.split(splitBy);

                String checkProductId = columns[0].toString();

                System.out.println("\nReading shopping-cart.csv\n\n");

                if (!checkProductId.equals(productToRemove)) {
                    System.out.println("ID found: " + checkProductId);
                    sb.append(currentLine).append("\n");
                } else {
                    System.out.println("ID not found: " + checkProductId);
                }
            }

            reader.close();
            writer.close();

            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("\nFILE NOT FOUND\n\n");
            e.printStackTrace();
        }
    }

}
