package com.example.softengproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.softengproject.entity.User;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
@SessionAttributes("")
public class UserController {
  
  @GetMapping
  public String showUserTemplate(Model model) {
    model.addAttribute("user", new User());
    return "user";
  }
    
}
