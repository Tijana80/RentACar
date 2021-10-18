package com.example.RentACar.controller;

import com.example.RentACar.dao.UserDao;
import com.example.RentACar.dao.UserDaoSQL;
import com.example.RentACar.model.UserModel;

import com.example.RentACar.model.request.LoginRequestModel;
import com.example.RentACar.model.request.RegisterRequestModel;
import com.example.RentACar.model.response.LoginResponseModel;
import com.example.RentACar.model.response.RegisterResponseModel;
import com.example.RentACar.model.response.UserResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class UserController {
    private static final UserDaoSQL userdaosql=new UserDaoSQL();
    private static final UserDao ud=new UserDaoSQL();
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> allUsers=userdaosql.getAllUsers();
        return allUsers;
    }
@PostMapping("/login")
    public LoginResponseModel login(@RequestBody LoginRequestModel lrm){
       // userdaosql.login(lrm.getIdentification(),lrm.getPassword())
                return new LoginResponseModel(true, "");
}
@GetMapping("/users/{id}")
    public UserResponseModel getUser(@PathVariable("id") UUID userId ){
        UserModel um=userdaosql.getUser(userId);
       return new UserResponseModel(um.getUsername(), um.getEmail(),um.getFirstName(),um.getLastName(),um.getPhoneNumber(),um.getPersonalNumber(),um.getImage());
}
@GetMapping("/register")
    public RegisterResponseModel rrm(@RequestBody RegisterRequestModel rrqm){
        return new RegisterResponseModel(true,"Uspesno ste se registrovali.");
}

}
