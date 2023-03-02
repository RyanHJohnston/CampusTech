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
  
  /**
   * Getter method using @GetMapping annotation
   * Return String value is 'index'
   * That is the name of the Thymeleaf template 'index.html'
   *
   * @param name String name of the model
   * @param model Model object of given class model 
   *
   * @return Template name using the {@link Model)
   *         If no name is given, default value is 'World'
   *         It's a Hello world test
   */
  @GetMapping(value = "/index")
  public String getTemplate(
      @RequestParam(name="name", required=false, defaultValue="World"
      ) String name, Model model) {

    model.addAttribute("name", name);
    return "index";
  }
}
