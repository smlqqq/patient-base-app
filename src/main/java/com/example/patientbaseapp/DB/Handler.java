package com.example.patientbaseapp.DB;
import com.example.patientbaseapp.Domain.Account;
import com.example.patientbaseapp.Domain.Patinets;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.*;

public class Handler   extends  Configs{
    Connection dbConnection;
   public  Connection getDbConnection() throws ClassNotFoundException , SQLException{

       String connectionString = "jdbc:mysql://" + dbHost + ":"
               + dbPort + "/" + dbName;


       Class.forName("com.mysql.cj.jdbc.Driver");
       dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
   return dbConnection;
   }


       public ResultSet getAccount(Account account){
       ResultSet resultSet = null;
        String select = "select * from docs  where ID =? AND password =?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, account.getID());
            preparedStatement.setString(2, account.getPassword());
           resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {

        }
        return resultSet;
    }


    public void setAccount (String setID, String setPass) {

        String setSelect = "insert into docs (ID,password)VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(setSelect);
            preparedStatement.setString(1, setID);
            preparedStatement.setString(2, setPass);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {

        }

    }



//    public ResultSet getPatient(Patinets patinets){
//        ResultSet resultSet = null;
//        String select = "select * from patients  where ID =? AND first_name =? AND last_name =? AND date_of_birth(age) =? AND diagnosis =?";
//        try {
//            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
//            preparedStatement.setString(1, patinets.getID());
//            preparedStatement.setString(2, patinets.getFirstName());
//            preparedStatement.setString(3, patinets.getLastName());
//            preparedStatement.setString(4, patinets.getDayOfBirth());
//            preparedStatement.setString(5, patinets.getDiagnosis());
//            resultSet = preparedStatement.executeQuery();
//        } catch (SQLException | ClassNotFoundException e) {
//
//        }
//        return resultSet;
//    }

    private ObservableList<ObservableList> data;
    private TableView getPatientTable;

    public void getPatient() {
        data = FXCollections.observableArrayList();
        try {
            String select = "select * from patients  where ID =? AND first_name =? AND last_name =? AND date_of_birth(age) =? AND diagnosis =?";

            ResultSet rs = dbConnection.createStatement().executeQuery(select);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                getPatientTable.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

                while(rs.next()){
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                        //Iterate Column
                        row.add(rs.getString(i));
                    }

                    data.add(row);

                }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    private ObservableList<Patinets> patientsData = FXCollections.observableArrayList();
//    public ObservableList<Patinets> getPersonData(){
//        ResultSet resultSet = null;
//        String select = "select * from patients  where ID =? AND first_name =? AND last_name =? AND date_of_birth(age) =? AND diagnosis =?";
//        try {
//            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
//            preparedStatement.setString(1, patinets.getID());
//            preparedStatement.setString(2, patinets.getFirstName());
//            preparedStatement.setString(3, patinets.getLastName());
//            preparedStatement.setString(4, patinets.getDayOfBirth());
//            preparedStatement.setString(5, patinets.getDiagnosis());
//            resultSet = preparedStatement.executeQuery();
//        } catch (SQLException | ClassNotFoundException e) {
//
//        }
//        return patientsData;
//    }



    public void setPatient(String setFirstName, String setLastName, String setDayOfBirth, String setDiagnosis) {

        String setSelect = "insert into patients (first_name,last_name,date_of_birth(age),diagnosis)VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(setSelect);

            preparedStatement.setString(2, setFirstName);
            preparedStatement.setString(3, setLastName);
            preparedStatement.setString(4, setDayOfBirth);
            preparedStatement.setString(5, setDiagnosis);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {

        }

    }





//    public ResultSet addUser(Account account) {
//        ResultSet resultSet = null;
//        String select = "insert into docs (ID, password) VALUES (?, ?)";
//        try (conn = dbConnection.getDbConnection();
//        pst = conn.prepareStatement(query)) {
//            pst.setString(1, txtFirstName.getText());
//            pst.setString(2, txtLastName.getText());
//            pst.setDate(3, java.sql.Date.valueOf(txtDOB.getValue()));
//            pst.executeUpdate();
//        }
//    catch (SQLException xSql) {
//            xSql.printStackTrace();
//        }
//    }



}
