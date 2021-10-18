package com.example.RentACar.dao;

import com.example.RentACar.db.DatabaseConnection;
import com.example.RentACar.model.UserModel;
import com.example.RentACar.model.request.LoginRequestModel;
import com.example.RentACar.model.request.RegisterRequestModel;
import com.example.RentACar.model.response.LoginResponseModel;
import com.example.RentACar.model.response.RegisterResponseModel;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public interface UserDao {
    Connection conn= DatabaseConnection.getConnection();
    UserModel getUser(UUID userId);
    List<UserModel> getAllUsers();
    void register(RegisterRequestModel rrm);
   LoginResponseModel login(LoginRequestModel lrm);

}
