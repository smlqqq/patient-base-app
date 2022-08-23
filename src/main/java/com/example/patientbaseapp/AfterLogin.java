package com.example.patientbaseapp;

import com.example.patientbaseapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AfterLogin {

    @FXML
    private Button log_out;
    @FXML
    public void docLogOut(ActionEvent event) throws Exception{
        Main m = new Main();
        m.changeScene("login-gui.fxml");

    }
}
