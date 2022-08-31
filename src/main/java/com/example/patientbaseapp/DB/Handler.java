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
       public ResultSet getAccount(Account account){
       ResultSet resultSet = null;
        String select = "select * from doc_log_id_password where ID =? AND Password =?";
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
