package com.example.patientbaseapp;

import com.example.patientbaseapp.DB.Configs;
import com.example.patientbaseapp.DB.Handler;
import com.example.patientbaseapp.Domain.Patients;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
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

    @FXML
    private Button regPatientBtn;
    @FXML
    private Button backBtn;

    public void PatientData(ActionEvent e) throws Exception {


        pateintReloadDB.setOnAction(actionEvent -> {
            try {
                getPatient();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

//        regPatientBtn.setOnAction(actionEvent->{
//            newScene("registrationPat.fxml");
//        });



    }

    public void setPatientsData(ActionEvent e) throws IOException {
//        regPatientBtn.setOnAction(actionEvent->{
//            newScene("registrationPat.fxml");
//        });

        //Close current
        Stage stage = (Stage) regPatientBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registrationPat.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registration Form");
        stage.setScene(new Scene(root1));
        stage.show();

    }






    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;


        Class.forName("org.postgres.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }


    public void getPatient() throws SQLException, ClassNotFoundException {
        Connection c = getDbConnection();
        data = FXCollections.observableArrayList();

//        ObservableList<String> row = FXCollections.observableArrayList();
//        try{
//            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM hospital_db.patients  where id =? AND first_name =? AND second_name =? AND day_of_birth =?");
//            ResultSet rs = preparedStatement.executeQuery();
//            while(rs.next()) {
//                row.add(String.valueOf(new Patients(Integer.parseInt(rs.getString("ID")), rs.getString("Name"), rs.getString("Surname"), rs.getString("Age"))));
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


       try {

            String selectPatients = "SELECT * FROM hospital_db.patients  where id =? AND first_name =? AND second_name =? AND day_of_birth =?";

            ResultSet rs = c.createStatement().executeQuery(selectPatients);
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
        }
    }
    public void newScene(String window) {
        regPatientBtn.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(window));
        try {
            fxmlLoader.load();
        } catch (IOException e) {  }

        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    }

