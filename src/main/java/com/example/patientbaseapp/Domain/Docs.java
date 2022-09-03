package com.example.patientbaseapp.Domain;

public class Docs {
    private String Login;
    private String Password;

    public Docs(String login, String password) {
        this.Login = login;
        this.Password = password;
    }


    public Docs(){

    }


    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

}
