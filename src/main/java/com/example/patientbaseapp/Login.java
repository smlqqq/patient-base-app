package com.example.patientbaseapp;
import com.example.patientbaseapp.DB.Handler;
import com.example.patientbaseapp.Domain.Account;
import com.example.patientbaseapp.Domain.Patinets;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login {

    public Login() {

    }

    @FXML
    private Button pateintReloadDB;
    @FXML
    private TableView<Patinets> getPatientTable;
    @FXML
    private TableColumn<Patinets, String> patientName;
    @FXML
    private TableColumn<Patinets, String> patientSurname;

    @FXML
    private TableColumn<Patinets, String> patientAge;
    @FXML
    private TextArea getPatientDiagnosis;


    @FXML
    private Button signUp_button;
    @FXML
    private TextField log_id_doc;
    @FXML
    private PasswordField log_pass_doc;

    @FXML
    private Button login_button;

    @FXML
    private TextField id_doc;

    @FXML
    private PasswordField pass_doc;

    @FXML
    private Label wrongLogin;


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Stage dialogStage = new Stage();
    Scene scene;


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

        Handler handler = new Handler();
        signUp_button.setOnAction(actionEvent -> {
        handler.setAccount(id_doc.getText(), pass_doc.getText());

                });



    }




    private void loginAcc(String logID, String pass) throws SQLException {
        Handler databaseHandler = new Handler();
        Account account = new Account();
        account.setID(logID);
        account.setPassword(pass);
        ResultSet result = databaseHandler.getAccount(account);
        if (result.next()) {
            infoBox("Login Successfull", "Success", null);
            newScene("after_login.fxml");
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

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }


//    public void addUser() {
//        String query = "INSERT into persons (Firstname, Lastname, DOB) VALUES (?, ?, ?)";
//        try (conn = DBConnection.DbConnector();
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