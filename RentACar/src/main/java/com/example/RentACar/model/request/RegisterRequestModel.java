package com.example.RentACar.model.request;

public class RegisterRequestModel {
    public String username;
    public  String email;
    public String password;

    public RegisterRequestModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


}
