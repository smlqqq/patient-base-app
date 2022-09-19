package com.example.patientbaseapp.DDD;

import com.example.patientbaseapp.Domain.Patients;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Test extends Application {
    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // создаем список объектов
        ObservableList<Patients> people = FXCollections.observableArrayList(

        );
        // определяем таблицу и устанавливаем данные
        TableView<Patients> table = new TableView<Patients>(people);
        table.setPrefWidth(250);
        table.setPrefHeight(200);

        // столбец для вывода имени
        TableColumn<Patients, String> nameColumn = new TableColumn<Patients, String>("Name");
        // определяем фабрику для столбца с привязкой к свойству name
        nameColumn.setCellValueFactory(new PropertyValueFactory<Patients, String>("first_name"));
        // добавляем столбец
        table.getColumns().add(nameColumn);

        // столбец для вывода возраста
        TableColumn<Patients, Integer> ageColumn = new TableColumn<Patients, Integer>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<Patients, Integer>("day_of_birth"));
        table.getColumns().add(ageColumn);

        FlowPane root = new FlowPane(10, 10, table);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("TableView in JavaFX");
        stage.show();
    }


}
