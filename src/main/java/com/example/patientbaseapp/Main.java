package com.example.patientbaseapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("login-gui.fxml"));
        primaryStage.setTitle(" ");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 740, 400));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}