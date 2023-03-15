package com.example.softengproject.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.softengproject.Model.Product;
import com.example.softengproject.Model.ShoppingCart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shopping-cart")
@SessionAttributes("")
public class ShoppingCartController {
  
  @GetMapping("/shopping-cart") 
  public String showShoppingCartTemplate(Model model) {
    model.addAttribute("shopping-cart", new ShoppingCart()); 
    return "shopping-cart";
  }
  
}
