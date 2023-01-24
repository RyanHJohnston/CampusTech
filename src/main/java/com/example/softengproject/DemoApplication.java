package com.example.softengproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/* 
 * Executes the entire web application
 * Application will not run unless DataSourceAutoConfiguration.class is 
 *  excluded in the SpringBootAppplication annotation
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {

    /**
     * Executes the main application
     * Leave this alone
     *
     * @param args Default String argument for main method
     */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
