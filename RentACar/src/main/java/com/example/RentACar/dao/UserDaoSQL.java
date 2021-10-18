package com.example.RentACar.dao;

import com.example.RentACar.db.DatabaseConnection;
import com.example.RentACar.model.UserModel;
import com.example.RentACar.model.request.LoginRequestModel;
import com.example.RentACar.model.request.RegisterRequestModel;
import com.example.RentACar.model.response.LoginResponseModel;
import com.example.RentACar.model.response.RegisterResponseModel;
import com.example.RentACar.model.response.UserResponseModel;
import org.apache.catalina.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoSQL implements UserDao{
    private static final Connection conn= DatabaseConnection.getConnection();
    static PreparedStatement st;

    @Override
    public UserModel getUser(UUID userId) {
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM users WHERE user_id= " +userId);
           if (rs.next()){
               return new UserModel(
                       UUID.fromString(rs.getString(1)),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getString(4),
                       rs.getString(5),
                       rs.getString(6),
                       rs.getString(7),
                       rs.getString(8),
                       rs.getString(9),
                       rs.getBoolean(10));

           }else {
               System.out.println("No result.");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> userList=new ArrayList<>();
        try {
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM users");
            while(rs.next()){
                UserModel um=new UserModel(
                        UUID.fromString(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBoolean(10));
                userList.add(um);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void register(RegisterRequestModel rrm) {//nije void
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO users (username,email,password) VALUES (?,?,?)");
         st.setString(2,rrm.username);
         st.setString(3,rrm.email);
         st.setString(4,rrm.password);
         st.executeUpdate();
         st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public LoginResponseModel login(LoginRequestModel lrm) {
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT password FROM users WHERE username = "+" OR email = "
                    );
           // return ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
