package com.example.softengproject.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.softengproject.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j              // Automatically generates a Slf4j (Simple Logging Facade for Java)
@Controller         // Identifies class as a Controller, Spring will discover it and
                    // automatically create an instance of the controller as a bean in the Spring
                    // Application context
@RequestMapping("/product") // temporary for testing
public class ProductController {
  
  @GetMapping("/product")
  public String showProductTemplate(Model model) {
    model.addAttribute("product", new Product()); 
    return "product";
  }
 
}
