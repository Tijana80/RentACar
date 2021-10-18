package com.example.RentACar.controller;

import com.example.RentACar.dao.CarDaoSQL;
import com.example.RentACar.model.CarModel;
import org.springframework.web.bind.annotation.*;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

@RestController
public class CarController {
    private static final CarDaoSQL cardaosql=new CarDaoSQL();

    @GetMapping("/cars/{carId}")
    //public CarModel get(@PathVariable("carId") String carId){return cardaosql.getCar(UUID.fromString(carId));
        public CarModel getCar(@PathVariable("carId") UUID carId){return cardaosql.getCar(UUID.fromString("carId"));}
    //}
@PostMapping("/cars")
    public CarModel  add(@RequestBody CarModel car){
        UUID u=UUID.randomUUID();
        CarModel cm=new CarModel();
        cardaosql.add(car);
return new  CarModel(car);


}
@GetMapping("/cars")
   public List<CarModel> getCars(){
   List<CarModel> allCars=cardaosql.getAllCars();
    return allCars;}

   @PostMapping("/cars/{carId}")
   public void deleteCar(@PathVariable("carId") UUID carId){
        cardaosql.delete(UUID.fromString("carId")); 
   }
}
