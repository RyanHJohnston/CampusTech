
package com.example.softengproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration; import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/* 
 * Executes the entire web application
 * Application will not run unless DataSourceAutoConfiguration.class is 
 *  excluded in the SpringBootAppplication annotation
 */
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@AutoConfiguration
@EnableAutoConfiguration
public class OnlineStoreWebApplication implements WebMvcConfigurer{

    /**
     * Executes the main application
     * Leave this alone
     *
     * @param args Default String argument for main method
     */
    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreWebApplication.class, args);
    }
     
    /**
     * Makes home.html the default page
     * Easier than creating a separate config class
     *
     * @param registry ViewControllerRegistry object 
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }


}
