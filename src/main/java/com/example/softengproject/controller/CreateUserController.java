package com.example.softengproject.controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.softengproject.entity.CreateUser;

import lombok.AllArgsConstructor;

@Controller
public class CreateUserController {
    
    @Autowired private JdbcTemplate jdbcTemplate;

    CreateUser user;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new CreateUser());

        return "signup";
    }

    @RequestMapping(value="/signup",method=RequestMethod.POST)
    public String submitSignupForm(@ModelAttribute CreateUser user) {
        System.out.println("\n\nNew user: " + user.getUsername() + "\n\n");
        
        // write data to user table
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        Random random = new Random();

        String sqlQuery = "INSERT INTO Users (auto_id, username, password, email) VALUES (?, ?, ?, ?)";

        Integer result = jdbcTemplate.update(sqlQuery, random.nextInt(10000000,99999999),username, password, email);

        if (result > 0) {
            System.out.println("\nUsers updated successfully\n\n");
        } else {
            System.out.println("\n\nUsers failed to update\n\n");
        }

        return "successfulSignup";
    }

    /*
    @RequestMapping(value="/login",method=RequestMethod.GET) 
    public String login(Model model) {
        model.addAttribute("user", new CreateUser());
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST) 
    public String loginCheck(Model model, @ModelAttribute CreateUser user) throws Exception {
        
        List<CreateUser> userList = new ArrayList<CreateUser>();

        userList = loadUsers();

        for (CreateUser index : userList) {
            if (index.getUsername().equals(user.getUsername())) {
                System.out.println("\nCorrect username: " + index.getUsername() + "\n\n");
                return "redirect:/home";
            }
        }


        return "redirect:/login";
    } */


      private java.util.List<CreateUser> loadUsers() throws Exception {
        List<CreateUser> list = new ArrayList<CreateUser>();
        String sqlQuery = "SELECT * FROM Users";
        try {
            // productList = readCSVFile(productList, filename);
            // product_id | name       | type    | description  | price | quantity | vendor      | rating | quantity_in_cart
            list = jdbcTemplate.query(sqlQuery, 
                    new Object[] {},
                    new RowMapper<CreateUser>() {
                        public CreateUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                            CreateUser p = new CreateUser();
                            p.setUsername(rs.getString(2));
                            p.setPassword(rs.getString(3));
                            p.setEmail(rs.getString(4));
                            return p; 
                        }
                    });
        
        System.out.println(list.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; 
    }


}
