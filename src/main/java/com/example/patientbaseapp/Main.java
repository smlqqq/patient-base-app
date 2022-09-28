package com.example.patientbaseapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
//        Parent root = FXMLLoader.load(getClass().getResource("login-gui.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("after_login3.fxml"));
        primaryStage.setTitle(" ");
        primaryStage.setResizable(false);
//        primaryStage.setScene(new Scene(root, 740, 400));
        primaryStage.setScene(new Scene(root, 1100, 800));
        primaryStage.show();
//        primaryStage.setResizable(false);
    }



    public static void main(String[] args) {
        launch(args);
    }
}