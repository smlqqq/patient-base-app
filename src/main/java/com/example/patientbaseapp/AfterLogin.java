package com.example.patientbaseapp;

import com.example.patientbaseapp.DB.Configs;
import com.example.patientbaseapp.DB.Handler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AfterLogin  extends Configs {
    private ObservableList<ObservableList> data;
    @FXML
    private TableView getPatientTable;
    public void PatientData(ActionEvent e) throws Exception {
        //TableView
        getPatientTable = new TableView();
        getPatient();

        //Main Scene
        Scene scene = new Scene(getPatientTable);

        stage.setScene(scene);
        stage.show();
    }

    Connection dbConnection;
    public  Connection getDbConnection() throws ClassNotFoundException , SQLException{

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;


        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }


    public void getPatient() {
        data = FXCollections.observableArrayList();
        try {
            String select = "select * from patients  where ID =? AND first_name =? AND last_name =? AND date_of_birth(age) =? AND diagnosis =?";

            ResultSet rs = getDbConnection().createStatement().executeQuery(select);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                getPatientTable.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }

                data.add(row);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
