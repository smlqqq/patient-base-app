package com.example.patientbaseapp;

import com.example.patientbaseapp.DB.Configs;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.*;

public class RegistrationPat extends Configs {
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
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException , SQLException {

        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;


        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }

    public void setPatient(String setFirstName, String setLastName, String setDayOfBirth, String setDiagnosis) {

        String setSelect = "insert into hospital_db.patients (first_name,second_name,day_of_birth,diagnosis)VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(setSelect);

            preparedStatement.setString(1, setFirstName);
            preparedStatement.setString(2, setLastName);
            preparedStatement.setString(3, setDayOfBirth);
            preparedStatement.setString(4, setDiagnosis);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {

        }

    }

    private ObservableList<ObservableList> data;
    private TableView getPatientTable;

    public void getPatient() {
        data = FXCollections.observableArrayList();
        try {
            String select = "SELECT * FROM hospital_db.patients  where id =? AND first_name =? AND second_name =? AND day_of_birth =? AND diagnosis =?";

            ResultSet rs = dbConnection.createStatement().executeQuery(select);

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
        }
    }

}
