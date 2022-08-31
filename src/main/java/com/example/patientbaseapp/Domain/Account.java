package com.example.patientbaseapp.Domain;

public class Account {
    private String ID;
    private String Password;

    public Account(String ID, String password) {
        this.ID = ID;
        this.Password = password;
    }

    public Account() {

    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


//
//    private static String idNumber;
//    private static String passNumber;
//
//
//    public Account(String id, String password) {
//        this.idNumber = id;
//        this.passNumber = password;
//
//    }
//
//
//    public static String getIdNumber() {
//
//        return idNumber;
//    }
//
//    public static String getPassNumber() {
//
//        return passNumber;
//    }
}
