package com.example.softengproject.controller; 

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shopping-cart")
public class InvoiceController extends HttpServlet {
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        // read form fields
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("\n\nInvoice controller => first name: "+firstName+"\n\n");
        System.out.println("\n\nInvoice controller => last name: "+lastName+"\n\n");

        // get response writer
        PrintWriter writer = response.getWriter();

        // build html code
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your first name is " + firstName + "</h2>";
        htmlResponse += "<h2>Your last name is " + lastName + "</h2>";
        htmlResponse += "</html>";

        writer.println(htmlResponse);
    }

}
