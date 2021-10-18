package com.example.RentACar.dao;

import com.example.RentACar.db.DatabaseConnection;
import com.example.RentACar.model.CarModel;
import com.example.RentACar.model.ContractModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CarDaoSQL implements CarDao{
    private static final Connection conn= DatabaseConnection.getConnection();
    static PreparedStatement st;
    @Override
    public List<CarModel> getAllCars() {
        List<CarModel>carList=new ArrayList<>();
        try {
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM cars");
            while(rs.next()){
                CarModel cm=new CarModel(
                 UUID.fromString(rs.getString(1)) , rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getDouble(8),rs.getInt(9), rs.getString(10),
                        rs.getInt(11), rs.getBoolean(12), rs.getString(13), rs.getString(14)
                );
                carList.add(cm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    @Override
    public List<CarModel> search(int year, String make, String model, boolean automatic, double price, int power, int doors) {
        List<CarModel>searchList=new ArrayList<>();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM cars WHERE year = "+ year +
                    "make= "+ make+
                    "model= " +model +
                    "automatic= "+automatic+
                    "price = " + price +
                    "power = " +power +
                    "doors= " +doors);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CarModel getCar(UUID carId) {
        try {
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM cars WHERE car_id = " + carId);
            rs.next();
            return new CarModel(
             UUID.fromString(rs.getString(1)) , rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                    rs.getInt(6), rs.getString(7), rs.getDouble(8),rs.getInt(9), rs.getString(10),
                    rs.getInt(11), rs.getBoolean(12), rs.getString(13), rs.getString(14)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(CarModel cm) {
        try {
         PreparedStatement st= conn.prepareStatement("UPDATE cars " +
                    "SET car_id = ?, " +
                    "SET licence_plate = ?, " +
                    "SET make = ?, " +
                    "SET model = ?, " +
                    "SET year = ?, " +
                    "SET engine_capacity = ?, " +
                    "SET color = ?, " +
                    "SET price = ?, " +
                    "SET doors = ?, " +
                    "SET size = ?, " +
                    "SET power = ?, " +
                    "SET automatic = ?, " +
                    "SET fuel = ?, " +
                    "SET image = ?, " +
                    "WHERE car_id = ?");
            st.setString(1,(String.valueOf(cm.getCarId())));
            st.setString(2, cm.getLicencePlate());
            st.setString(3,cm.getMake());
            st.setString(4,cm.getModel());
            st.setInt(5,cm.getYear());
            st.setInt(6,cm.getEngineCapacity());
            st.setString(7,cm.getColor());
            st.setDouble(8,cm.getPrice());
            st.setInt(9,cm.getDoors());
            st.setString(10,cm.getSize());
            st.setInt(11,cm.getPower());
            st.setBoolean(12,cm.isAutomatic());
            st.setString(13,cm.getFuel());
            st.setString(14,cm.getImage());
            st.setString(15, String.valueOf(cm.getCarId()));
            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(UUID carId) {
        try {
            PreparedStatement st=conn.prepareStatement("DELETE FROM cars WHERE car_id = ?");
            st.setString(1,String.valueOf(carId));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(CarModel cm) {

        try {
         PreparedStatement st = conn.prepareStatement("INSERT INTO cars VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, String.valueOf(cm.getCarId()));
            st.setString(2, cm.getLicencePlate());
            st.setString(3,cm.getMake());
            st.setString(4,cm.getModel());
            st.setInt(5,cm.getYear());
            st.setInt(6,cm.getEngineCapacity());
            st.setString(7,cm.getColor());
            st.setDouble(8,cm.getPrice());
            st.setInt(9,cm.getDoors());
            st.setString(10,cm.getSize());
            st.setInt(11,cm.getPower());
            st.setBoolean(12,cm.isAutomatic());
            st.setString(13,cm.getFuel());
            st.setString(14,cm.getImage());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }


    }

    @Override
    public List<CarModel> availableCars(LocalDate startDate, LocalDate endDate) {
        List<CarModel>available=new ArrayList<>();
        Statement st= null;
        try {
            st = conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT start_date,end_date FROM contracts INNER JOIN cars ON contracts.car_id=cars.car_id WHERE end_date-start_date=0");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return available;
    }

    @Override
    public List<CarModel> avlSearchCars() {
        return null;
    }

    @Override
    public List<LocalDate> unavailableDates(UUID carId) {
        List<LocalDate>dates = new ArrayList<>();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT start_date,end_date" +
                    "FROM contracts" +
                    "WHERE car_i = '" + carId + "';");
            while(rs.next()){
               // dates.addAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
