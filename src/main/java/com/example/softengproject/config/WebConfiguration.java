package com.example.softengproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { 
            registry.addResourceHandler("/**")
                 .addResourceLocations("classpath:/static/");
    }

    public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/").setViewName("home");
    
    registry.addViewController("/login").setViewName("login");
  }

}
