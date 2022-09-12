package com.example.patientbaseapp;

import com.example.patientbaseapp.DB.Configs;
import com.example.patientbaseapp.Domain.Patients;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.*;

public class AfterLogin  extends Configs {
    private ObservableList<ObservableList> data;
    @FXML
    private TableView getPatientTable;
    @FXML
    private Button pateintReloadDB;
    @FXML
    private TableColumn<Patients, Integer> patientID;
    @FXML
    private TableColumn<Patients, String> patientName;
    @FXML
    private TableColumn<Patients, String> patientSurname;

    @FXML
    private TableColumn<Patients, String> patientAge;
    @FXML
    private TextArea getPatientDiagnosis;

    public void PatientData(ActionEvent e) throws Exception {


        pateintReloadDB.setOnAction(actionEvent -> {
            try {
                getPatient();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });


    }

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;


        Class.forName("org.postgres.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }



    public void getPatient() throws SQLException, ClassNotFoundException {
        Connection c = getDbConnection();
        data = FXCollections.observableArrayList();
//        ObservableList<String> row = FXCollections.observableArrayList();
//        try{
//            PreparedStatement preparedStatement = c.prepareStatement("select * from patients");
//            ResultSet rs = preparedStatement.executeQuery();
//            while(rs.next()) {
//                row.add(new Patinets(Integer.parseInt(rs.getString("ID")), rs.getString("Name"), rs.getString(""));
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        try {
            String selectPatients = "SELECT * FROM hospital.patients ";
            ResultSet rs = getDbConnection().createStatement().executeQuery(selectPatients);
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
            getPatientTable.setItems(data);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
