package com.example.softengproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


/* Initiates thymeleaf template (index.html) 
 * This is where we will manipulate the data in the frontend
 * We can modify the name of the controller class later
 */

@Controller
public class DemoController {
  
  @GetMapping("/")
  public String home() { 
    return "home";
  }

}
