//package com.example.patientbaseapp.Controller;
//
//import javafx.beans.property.ReadOnlyStringProperty;
//import javafx.beans.property.ReadOnlyStringWrapper;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//public class User {
//    private final static String USERNAME_PROP_NAME = "userName";
//    private final static String PASSWORD_PROP_NAME = "password";
//
//    private final ReadOnlyStringWrapper userName;
//    private StringProperty password;
//
//    public User()
//    {
//        userName = new ReadOnlyStringWrapper(this, USERNAME_PROP_NAME, System.getProperty("user.name"));
//        password = new SimpleStringProperty(this, PASSWORD_PROP_NAME, "");
//    }
//    public final String getUserName()
//    {
//        return userName.get();
//    }
//    public final String getPassword()
//    {
//        return password.get();
//    }
//
//    public final void setPassword(String password)
//    {
//        this.password.set(password);
//    }
//    public ReadOnlyStringProperty userNameProperty()
//    {
//        return userName.getReadOnlyProperty();
//    }
//
//    public StringProperty passwordProperty()
//    {
//        return password;
//    }
//    public String toString()
//    {
//        return String.format("User[username=%s, password=%s]",getUserName(),getPassword());
//    }
//}
//
