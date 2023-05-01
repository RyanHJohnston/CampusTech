package com.example.softengproject.entity;

public class CreateUser {
    
    private Integer autoId;
    private String username;
    private String email;
    private String password;
    // public CreateUser(String newUsername, String newPassword){
    //   this.username = newUsername;
    //   this.password = newPassword;
    // }
    
    // getters and setters
    
    public CreateUser(){}
    
    public CreateUser(Integer autoId, String username, String password, String email) {
        this.autoId = autoId; 
        this.username = username;
        this.password = password;
        this.email = email;
    }

    
    public String getUsername() {
      return username;
    }
    
    public void setUsername(String username) {
      this.username = username;
    }
    
    public String getEmail() {
      return email;
    }
    
    public void setEmail(String email) {
      this.email = email;
    }
    
    public String getPassword() {
      return password;
    }
    
    public void setPassword(String password) {
      this.password = password;
    }
    
    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }
}
