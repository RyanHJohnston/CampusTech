package com.example.softengproject.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.softengproject.entity.CreateUser;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired private JdbcTemplate jdbcTemplate;
    
     
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/", "/home", "/signup", "/desktops","/laptops","/phones","/shopping-cart","/accessories","/about").permitAll()
                    .anyRequest().authenticated()
                    )
            .formLogin((form) -> form
                    .loginPage("/login")
                    .permitAll()
                    )
            .logout((logout) -> logout.permitAll());

        return http.build();
    }
    
    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withUsername("employee").password(passwordEncoder().encode("password"))
                .roles("EMPLOYEE", "USER").build());
        userDetailsList.add(User.withUsername("manager").password(passwordEncoder().encode("password"))
                .roles("MANAGER", "USER").build());

        return new InMemoryUserDetailsManager(userDetailsList);
    } */
    
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        List<CreateUser> userList = new ArrayList<CreateUser>();

        userList = loadUsers();

        List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
          
        for (CreateUser index : userList) {
            // userDetailsList.add(User.withDefaultPasswordEncoder().username(index.getUsername()).password(index.getPassword()).roles("USER").build());
            // userDetailsList.add(User.withUsername(index.getUsername()).roles("USER").build());
            userDetailsList.add(User.withUsername(index.getUsername()).password(passwordEncoder().encode(index.getPassword())).roles("USER").build());
        } 
    
        
        UserDetails user =
            User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();


        UserDetails admin =
            User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(userDetailsList.get(1));
    }

    private java.util.List<CreateUser> loadUsers() {
        List<CreateUser> list = new ArrayList<CreateUser>();
        String sqlQuery = "SELECT * FROM Users";
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

        return list; 
    }
}
