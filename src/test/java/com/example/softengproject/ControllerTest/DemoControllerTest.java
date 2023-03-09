package com.example.softengproject.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.softengproject.Controller.DemoController;

@WebMvcTest (DemoController.class) // Web test for DemoController
public class DemoControllerTest {
  
  @Autowired
  private MockMvc mockMvc; // Injects MockMvc
  
  @Test
  public void testHomePage() throws Exception {
    mockMvc.perform(get("/")) // Performs GET / Request
      .andExpect(status().isOk()) // Expects HTTP 200
      .andExpect(view().name("home")) // Expects home view
      .andExpect(content().string( // Expects "Welcome to..."
       containsString("Welcome to...")));
  }
}
