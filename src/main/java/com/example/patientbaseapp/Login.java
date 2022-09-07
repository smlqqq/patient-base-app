package com.example.patientbaseapp;
import com.example.patientbaseapp.DB.Handler;
import com.example.patientbaseapp.Domain.Docs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login {

    public Login() {

    }

    @FXML
    private Button login_button;

    @FXML
    private TextField id_doc;

    @FXML
    private PasswordField pass_doc;

    @FXML
    private Label wrongLogin;


    @FXML
    void initialize() {
        login_button.setOnAction(event -> {
            String accLogin = id_doc.getText().trim();
            String accPass = pass_doc.getText().trim();
            if (!accLogin.equals("") && !accPass.equals("")) {
                try {
                    loginAcc(accLogin, accPass);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {

                }
            } else {
                wrongLogin.setText("Login and Password is empty!");
            }
        });
    }


    private void loginAcc(String logLogin, String pass) throws SQLException {
        Handler databaseHandler = new Handler();
        Docs docs = new Docs();
        docs.setLogin(logLogin);
        docs.setPassword(pass);
        ResultSet result = databaseHandler.getAccount(docs);
        if (result.next()) {
            newScene("patients.fxml");
        } else {

        }
    }
    public void newScene(String window) {
        login_button.getScene().getWindow().hide();
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

    public void searchPatients(ActionEvent actionEvent) {
    }

    public void deletePatient(ActionEvent actionEvent) {
    }

    public void updateEmployeeEmail(ActionEvent actionEvent) {
    }

    public void insertPatient(ActionEvent actionEvent) {
    }

    public void searchPatient(ActionEvent actionEvent) {
    }
}