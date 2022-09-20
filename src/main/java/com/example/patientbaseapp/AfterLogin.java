package com.example.patientbaseapp;

import com.example.patientbaseapp.DB.Configs;
import com.example.patientbaseapp.Domain.Patients;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.sql.*;

public class AfterLogin  extends Configs {
    private ObservableList<ObservableList> data;

    @FXML
    private TableView patientsTable;
    @FXML
    private TableColumn<Patients, Integer> patIDcolumn;
    @FXML
    private TableColumn<Patients, String> patNamecolumn;
    @FXML
    private TableColumn<Patients, String> patSurnamecolumn;
    @FXML
    private TableColumn<Patients, String> patDayOfBirthcolumn;

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
//                onEdit();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

//        if (getPatientTable.getSelectionModel().getSelectedItem() != null) {
//            Patients selectedPatient = (Patients) getPatientTable.getSelectionModel().getSelectedItem();
//            patientID.setText(String.valueOf(selectedPatient.getId()));
//            patientName.setText(selectedPatient.getFirstName());
//            patientSurname.setText(selectedPatient.getLastName());
//            patientAge.setText(selectedPatient.getDayOfBirth());
//
//
//
//        }

    }

    public void setPatientsData(ActionEvent e) throws IOException {
        //Close current
        Stage stage = (Stage) regPatientBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registrationPat.fxml"));
        Parent root1 = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registration Form");
        stage.setScene(new Scene(root1));
        stage.show();

    }

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://abul.db.elephantsql.com:5432/ckkttdhb", "ckkttdhb", "nozrUH1mHHpvvm8s9L_JPAgb1bm14w20");

//        String connectionString = "jdbc:postgresql://" + dbHost + ":"
//                + dbPort + "/" + dbName;
//
//
//        Class.forName("org.postgres.Driver");
//        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
//        return dbConnection;
    }


    public void getPatient() throws SQLException, ClassNotFoundException {
        String selectPatients = "SELECT id, first_name, second_name, day_of_birth FROM hospital_db.patients";
        try {


            Connection c = getDbConnection();
            ObservableList<Patients> patients = FXCollections.observableArrayList();
            //  data = FXCollections.observableArrayList();
            ResultSet rs = c.createStatement().executeQuery(selectPatients);

            while (rs.next()) {
                Integer patID = rs.getInt("id");
                String patName = rs.getString("first_name");
                String patSurName = rs.getString("second_name");
                String patDOB = rs.getString("day_of_birth");

                patients.add(new Patients(patID, patName, patSurName, patDOB));
            }
            patientID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            patientName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            patientSurname.setCellValueFactory(new PropertyValueFactory<>("SurName"));
            patientAge.setCellValueFactory(new PropertyValueFactory<>("Age(DOB)"));


            getPatientTable.setItems(patients);





        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void onEdit(){

     if (getPatientTable.getSelectionModel().getSelectedItem() != null) {
         Patients selectedPatient = (Patients) getPatientTable.getSelectionModel().getSelectedItem();
         patientID.setText(String.valueOf(selectedPatient.getID()));
         patientName.setText(selectedPatient.getFirstName());
         patientSurname.setText(selectedPatient.getLastName());
         patientAge.setText(selectedPatient.getDayOfBirth());


     }
    }




//        Connection c = getDbConnection();
//        data = FXCollections.observableArrayList();
//
////        ObservableList<String> row = FXCollections.observableArrayList();
////        try{
////            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM hospital_db.patients  where id =? AND first_name =? AND second_name =? AND day_of_birth =?");
////            ResultSet rs = preparedStatement.executeQuery();
////            while(rs.next()) {
////                row.add(String.valueOf(new Patients(Integer.parseInt(rs.getString("ID")), rs.getString("Name"), rs.getString("Surname"), rs.getString("Age"))));
////
////            }
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        }
//
//        try {
////            String selectPatients = "SELECT * FROM hospital_db.patients";
//            String selectPatients = "SELECT id, first_name, second_name, day_of_birth FROM hospital_db.patients";
//
////            String selectDiagnosis = "SELECT diagnosis FROM hospital_db.patients";
////            ResultSet rsDiagnosis = c.createStatement().executeQuery(selectDiagnosis);
//
//
//
//
//            ResultSet rs = c.createStatement().executeQuery(selectPatients);
//            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                //We are using non property style for making dynamic table
//                final int j = i;
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
//
//                getPatientTable.getColumns().addAll(col);
//
//
//            }
//            while (rs.next()) {
//                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//                    //Iterate Column
//
//                    row.add(rs.getString(i));
//
//                }
//                data.add(row);
//            }
//            getPatientTable.setItems(data);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}



