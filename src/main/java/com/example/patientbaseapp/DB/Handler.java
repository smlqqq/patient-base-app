package com.example.patientbaseapp.DB;
import com.example.patientbaseapp.Domain.Account;

import java.sql.*;

public class Handler   extends  Configs{
    Connection dbConnection;
   public Connection getDbConnection() throws ClassNotFoundException , SQLException{

       String connectionString = "jdbc:mysql://" + dbHost + ":"
               + dbPort + "/" + dbName;


       Class.forName("com.mysql.cj.jdbc.Driver");
       dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
   return dbConnection;
   }

//    public void signUpAcc(Account account) {
//
//        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
//                Const.USER_ID + "," + Const.USER_PASSWORD + ")" + "VALUES(?,?,?)" ;
//
//        try {
//            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
//            preparedStatement.setString(1, account.getID());
//            preparedStatement.setString(2, account.getPassword());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//
//        } catch (ClassNotFoundException e) {
//
//        }
//    }
    public ResultSet getAccount(Account account){
       ResultSet resultSet = null;
        String select  = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_ID + "=? AND " + Const.USER_PASSWORD + "=?" ;

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, account.getID());
            preparedStatement.setString(2, account.getPassword());
           resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {

        }
        return resultSet;
    }



}
