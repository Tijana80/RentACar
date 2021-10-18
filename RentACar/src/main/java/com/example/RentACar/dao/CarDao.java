package com.example.RentACar.dao;

import com.example.RentACar.db.DatabaseConnection;
import com.example.RentACar.model.CarModel;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CarDao {

     List<CarModel>getAllCars();
     List<CarModel>search(int year,String make,String model,boolean automatic,double price,int power,int doors);
     CarModel getCar(UUID carId);
     void update(CarModel cm);
     void delete(UUID carId);
     void add(CarModel cm);
     List<CarModel>availableCars(LocalDate startDate, LocalDate endDate);
     List <CarModel>avlSearchCars();
     List<LocalDate>unavailableDates(UUID carId);



}
