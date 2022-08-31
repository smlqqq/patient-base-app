package com.example.patientbaseapp.Domain;

public class Account {
    private String ID;
    private String Password;

    public Account(String ID, String password) {
        this.ID = ID;
        this.Password = password;
    }


    public Account(){

    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

}
