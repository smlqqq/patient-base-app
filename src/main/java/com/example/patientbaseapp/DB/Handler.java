package com.example.patientbaseapp.DB;
import com.example.patientbaseapp.Domain.Account;
import java.sql.*;

public class Handler   extends  Configs{
    Connection dbConnection;
   public  Connection getDbConnection() throws ClassNotFoundException , SQLException{

       String connectionString = "jdbc:postgresql://" + dbHost + ":"
               + dbPort + "/" + dbName;
       Class.forName("org.postgresql.Driver");
       dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
       return dbConnection;
   }

       public ResultSet getAccount(Account account){
       ResultSet resultSet = null;
//        String select = "select * from hospital_db  where login =? AND password =?";
          String getSelect = "SELECT * FROM hospital_db.docs where login =? AND password =?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(getSelect);
            preparedStatement.setString(1, account.getLogin());
            preparedStatement.setString(2, account.getPassword());
           resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {

        }
        return resultSet;
    }
}
