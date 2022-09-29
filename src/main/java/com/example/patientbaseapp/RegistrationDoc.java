package com.example.patientbaseapp;
import com.example.patientbaseapp.DB.Handler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDoc extends Handler {
    @FXML
    private TextField login_doc_reg;

    @FXML
    private PasswordField password_doc_reg;

    @FXML
    private TextField name_doc_reg;

    @FXML
    private TextField surname_doc_reg;

    @FXML
    private Button signUp_button;

    @FXML
    private Button back_btn;

    public void setAccount (String setLogin, String setPass, String setName, String setSurName) {

        String setSelect = "INSERT INTO hospital_db.docs (login,password,first_name,second_name)VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(setSelect);
            preparedStatement.setString(1, setLogin);
            preparedStatement.setString(2, setPass);
            preparedStatement.setString(3, setName);
            preparedStatement.setString(4, setSurName);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {   }

    }

    @FXML
        public void initialize(){

        RegistrationDoc registration = new RegistrationDoc();
        signUp_button.setOnAction(ActionEvent -> {
            registration.setAccount(login_doc_reg.getText(), password_doc_reg.getText(), name_doc_reg.getText(), surname_doc_reg.getText());
            infoBox("Registration Successfull", "Success", null);

        });

    }

    public void backStage(ActionEvent e) throws IOException {
        Stage stage = (Stage) back_btn.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-gui.fxml"));
        Parent root1 = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Login");
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

}
