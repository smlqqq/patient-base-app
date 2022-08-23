package com.example.patientbaseapp;


import com.example.patientbaseapp.Log.LOG;
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
public void userLogIn(ActionEvent event) throws Exception{
        checkLogIn();

    }

    private void checkLogIn()throws Exception{
        Main m = new Main();
        if(id_doc.getText().toString().equals(LOG.return_doc()) && pass_doc.getText().toString().equals("asdasdasd")){
            wrongLogin.setText("Succes");
            m.changeScene("after_login.fxml");
        }

        else if(id_doc.getText().isEmpty() && pass_doc.getText().isEmpty()){
            wrongLogin.setText("Is Empty");
        }
        else {
            wrongLogin.setText("Try again");
        }
    }



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
