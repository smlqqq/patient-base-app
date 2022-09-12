package com.example.patientbaseapp.Domain;

public class Account {
    private String Login;
    private String Password;

    private String Name;
    private String SurName;




    public Account(){

    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public Account(String login, String password, String name, String surName) {
        Login = login;
        Password = password;
        Name = name;
        SurName = surName;
    }
}
