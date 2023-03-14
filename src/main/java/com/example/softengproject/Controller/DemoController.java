package com.example.softengproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/* Initiates thymeleaf template (index.html) 
 * This is where we will manipulate the data in the frontend
 * We can modify the name of the controller class later
 */

@Controller
@Slf4j
@RequestMapping("/index")
public class DemoController {
  
  @GetMapping
  public String showIndexTemplate() { 
    return "index";
  }
 
}
