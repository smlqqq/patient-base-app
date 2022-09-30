package com.example.patientbaseapp.DB;

import com.example.patientbaseapp.Domain.Docs;

import java.sql.*;

public class Handler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;


        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public ResultSet getAccount(Docs docs){
        ResultSet resultSet = null;
        String select = "select * from hospital_db.docs where login =? AND password =?";


        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, docs.getLogin());
            preparedStatement.setString(2, docs.getPassword());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {

        }
        return resultSet;
    }

}
