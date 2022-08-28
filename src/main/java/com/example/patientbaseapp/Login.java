package com.example.patientbaseapp;



import com.example.patientbaseapp.DB.Const;
import com.example.patientbaseapp.DB.Handler;
//import com.example.patientbaseapp.Domain.Account;
import com.example.patientbaseapp.Domain.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Login {

    public Login(){

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
void initialize() throws Exception {
    Main m = new Main();

login_button.setOnAction(event -> {


    String accID = id_doc.getText().trim();
    String accPass = pass_doc.getText().trim();


    if (!accID.equals("") && !accPass.equals("")) {
        loginAcc(accID, accPass);

            m.changeScene("after_login.fxml");


    } else
        wrongLogin.setText("Wrong");

});

//    checkLogIn();

    }

//    private void checkLogIn()throws Exception {
//
//
//
//
//        Main m = new Main();
//
//        String accID = id_doc.getText().trim();
//        String accPass = pass_doc.getText().trim();
//
//        if (!accID.equals("") && !accPass.equals("")) {
//            loginAcc(accID,accPass);
//            try {
//                m.changeScene("after_login.fxml");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        } else
//            wrongLogin.setText("Wrong");
//
//
//    }
    private void loginAcc(String id, String password) {
        Handler databaseHandler = new Handler();
        Account account = new Account();
        account.setID(id);
        account.setPassword(password);
        ResultSet result = databaseHandler.getAccount(account);

        int counter = 0;
        try {


        while (result.next()) {
            counter++;

        }
    }catch (SQLException e){

        }
        if(counter>=1){
            wrongLogin.setText("Succes");
        }

    }

//    private void signUpAccount() {
//        Handler databaseHandler = new Handler();
//        String accID = id_doc.getText().trim();
//        String accPass = pass_doc.getText().trim();
//        Account account = new Account(accID, accPass);
//       databaseHandler.getAccount(account);
//    }


//    void initialize() {
//
//        final Text actiontarget = new Text();
//
//
//        login_button.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent e) {
//                actiontarget.setFill(Color.FIREBRICK);
//                actiontarget.setText("Sign in button pressed");
//                String username = id_doc.getText().toString();
//                String password = pass_doc.getText().toString();
//                if (username.equals(ID.login_id()) && password.equals(PASSWORD.pass_word())) {
//                    System.out.println("Login Successful");
//                } else {
//                    System.out.println("Enter Valid username and password");
//                }
//                id_doc.setText("");
//                pass_doc.setText("");
//            }
//        });
//    }
}


//    /@FXML
//    public void login_button(ActionEvent e) throws IOException {
//        String username = id_doc.getText();
//        String password = pass_doc.getText();
//        System.out.println(username + password);
//        if(username.equals(username1) && password.equals(secretPw1)) {
//            System.out.println("Succesful login");
//            Stage stage = (Stage) id_doc.getScene().getWindow();
//            Parent root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
//            stage.setScene(new Scene(root));
//            stage.centerOnScreen();
//            stage.setTitle("Sapply - Administrator");
//        }else {
//            System.out.println("Wrong username or password");
//        }
//--------------------------------------------------------------------------
//    @FXML
//    void initialize() {




//        login_button.setOnAction(actionEvent -> {
//            try {
//                first_valuta_pokupka.setText(String.valueOf(Valutare.USD()));
//                second_valuta_pokupka.setText(String.valueOf(Valutare.EUR()));
//                third_valuta_pokupka.setText(String.valueOf(Valutare.RON()));
//                fourth_valuta_pokupka.setText(String.valueOf(Valutare.UAH()));
//                fifth_valuta_pokupka.setText(String.valueOf(Valutare.GBP()));
//                shapka_data.setText(String.valueOf(Head.shapkaVal()));
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//}
