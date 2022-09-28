package com.example.patientbaseapp;

import com.example.patientbaseapp.DB.Configs;
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
import javafx.util.Callback;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Pattern;

public class RegistrationPat extends Configs {


    @FXML
    private Button signUp_button;
    @FXML
    private Button regPatientBtn;
    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField dateOfBirth;
    @FXML
    private TextField diagnosisText;
    @FXML
    private Button patientAdd;
    @FXML
    private Button backBtn;


    Connection dbConnection;
    private String setFirstName;
    private String setLastName;
    private String setDayOfBirth;
    private String setDiagnosis;



    public Connection getDbConnection() throws ClassNotFoundException , SQLException {

        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;


        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }

    public void setPatient(String setFirstName, String setLastName, String setDayOfBirth, String setDiagnosis) {

        String setSelect = "insert into hospital_db.patients (first_name,second_name,day_of_birth,diagnosis)VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(setSelect);
            preparedStatement.setString(1, setFirstName);
            preparedStatement.setString(2, setLastName);
            preparedStatement.setString(3, setDayOfBirth);
            preparedStatement.setString(4, setDiagnosis);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {

        }

    }

    @FXML
    public void initialize(){
        RegistrationPat registration = new RegistrationPat();
        patientAdd.setOnAction(ActionEvent -> {
            if(nameText.getText().matches("\\d+")||nameText.getText().equals("")) {
                infoBox("Registration not Successfull, \nPlease, enter the Name. \nUse characters only.", "Warning", null);
            } else if (surnameText.getText().matches("\\d+") ||surnameText.getText().equals("")) {
                infoBox("Registration not Successfull,  \nPlease, enter the Surname \nUse characters only.", "Warning", null);
            } else if (dateOfBirth.getText().matches("[a-zA-Z]+") || dateOfBirth.getText().equals("")) {
                infoBox("Registration not Successfull,   \nPlease, enter right DOB \nMust contains only numbers \nFormat (dd/mm/yyyy) or (dd.mm.yyyy)", "Warning", null);
            } else if (diagnosisText.getText().equals("")) {
                infoBox("Registration not Successfull,   \nPlease, enter Diagnosis", "Success", null);
            }else {
                registration.setPatient(nameText.getText(), surnameText.getText(), dateOfBirth.getText(), diagnosisText.getText());
                infoBox("Registration Successfull", "Success", null);
            }
        });


    }
    public void backStage(ActionEvent e) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("after_login3.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("DB");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setResizable(false);
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    public void newScene(String window) {
        signUp_button.getScene().getWindow().hide();


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

