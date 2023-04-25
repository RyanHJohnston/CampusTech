package com.example.softengproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.softengproject.entity.CreateUser;

@Controller
public class CreateUserController {

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
      model.addAttribute("user", new CreateUser());
      
      return "signup";
    }
    
    @PostMapping("/signup")
    public String submitSignupForm(CreateUser user) {
      // Save user data to database
      return "successfulSignup";
    }
    
    
}
