package com.example.RentACar.dao;

import com.example.RentACar.db.DatabaseConnection;
import com.example.RentACar.model.ContractModel;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ContractDao {
    Connection conn= DatabaseConnection.getConnection();

    void add (ContractModel ccm);
    List<ContractModel>getAllContracts();
    void updateContract(UUID contractId,Boolean approved);
    void deleteContract(UUID contractId);
}
