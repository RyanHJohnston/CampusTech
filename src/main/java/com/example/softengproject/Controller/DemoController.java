package com.example.softengproject.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.Iterators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
@RequestMapping("/index")
public class DemoController {
  
  @GetMapping
  public String showTemplate() {
    return "index";
  }
  
}
