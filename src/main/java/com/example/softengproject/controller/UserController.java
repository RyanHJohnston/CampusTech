package com.example.softengproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.softengproject.entity.User;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = {"/login"})
public class UserController {
  
    @RequestMapping(value="/home",method=RequestMethod.GET) 
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User()); 
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String submitLoginForm(Model model, @ModelAttribute User user) {
        

        
        return "redirect:/home";
    }


    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String showRegisterForm(Model model) {
        


        return "register";
    }


    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String submitRegisterForm(Model model) {

        

        return "redirect:/login";
    }

}
