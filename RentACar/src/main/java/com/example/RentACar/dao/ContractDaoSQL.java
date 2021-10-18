package com.example.RentACar.dao;

import com.example.RentACar.db.DatabaseConnection;
import com.example.RentACar.model.ContractModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ContractDaoSQL implements ContractDao{
    private static final Connection conn= DatabaseConnection.getConnection();
    static PreparedStatement st;

    @Override
    public void add(ContractModel ccm) {

    }

    @Override
    public List<ContractModel> getAllContracts() {
        return null;
    }

    @Override
    public void updateContract(UUID contractId, Boolean approved) {
        try {
            PreparedStatement st=conn.prepareStatement("UPDATE contracts" + "SET approved = ?" + "WHERE contract_id = ?");
            st.setBoolean(1,approved);
            st.setString(2,String.valueOf(contractId));
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteContract(UUID contractId) {
        try {
            PreparedStatement st=conn.prepareStatement("DELETE FROM contracts WHERE contract_id = ?");
            st.setString(1,String.valueOf(contractId));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
