package com.example.RentACar.model.response;

public class RegisterResponseModel {
    public boolean successful;
    public String massage;

    public RegisterResponseModel(boolean successful, String massage) {
        this.successful = successful;
        this.massage = massage;
    }

    public boolean isSuccessful() {
        return successful;
    }


    public String getMassage() {
        return massage;
    }


}
