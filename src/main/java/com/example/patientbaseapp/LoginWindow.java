package com.example.patientbaseapp;
import com.example.patientbaseapp.DB.Handler;
import com.example.patientbaseapp.Domain.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginWindow {

    public LoginWindow() {  }

    @FXML
    private Button login_button;

    @FXML
    private TextField id_doc;

    @FXML
    private PasswordField pass_doc;

    @FXML
    private Button Reg_btn;


    @FXML
    void initialize() {
        login_button.setOnAction(event -> {
            String accID = id_doc.getText().trim();
            String accPass = pass_doc.getText().trim();
            if (!accID.equals("") && !accPass.equals("")) {
                try {
                    loginAcc(accID, accPass);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {

                }

                } else {
                infoBox("Enter Correct ID and/or Password", "Failed", null);

            }
        });

        Reg_btn.setOnAction(event -> {
            newScene("registrationDoc.fxml");
        });

    }

    private void loginAcc(String login, String pass) throws SQLException {
        Handler databaseHandler = new Handler();
        Account account = new Account();
        account.setLogin(login);
        account.setPassword(pass);
        ResultSet result = databaseHandler.getAccount(account);
        if (result.next()) {
            infoBox("Login Successfull", "Success", null);
            newScene("after_login.fxml");
        } else {
            infoBox("Warning! \nLogin and/or Password \nIs wrong.", "Warning", null);
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
            stage.setTitle("Main");
            stage.setScene(new Scene(root));
            stage.showAndWait();
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

}