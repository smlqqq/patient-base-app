package com.example.patientbaseapp.Domain;

public class Account {
    private String Login;
    private String Password;

    public Account(String login, String password) {
        this.Login = login;
        this.Password = password;
    }


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
}
