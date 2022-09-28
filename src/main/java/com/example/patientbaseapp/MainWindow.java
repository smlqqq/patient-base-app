package com.example.patientbaseapp;
import com.example.patientbaseapp.DB.Configs;
import com.example.patientbaseapp.Domain.Patients;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class MainWindow extends Configs {
    private ObservableList<ObservableList> data;


    @FXML
    private TableView patientsTable;
    @FXML
    private TableColumn<Patients, Integer> patIDcolumn;
    @FXML
    private TableColumn<Patients, String> patNamecolumn;
    @FXML
    private TableColumn<Patients, String> patSurnamecolumn;
    @FXML
    private TableColumn<Patients, String> patDayOfBirthcolumn;

    @FXML
    private TableView getPatientTable;
    @FXML
    private Button pateintReloadDB;
    @FXML
    private TableColumn<Patients, Integer> patientID;
    @FXML
    private TableColumn<Patients, String> patientName;
    @FXML
    private TableColumn<Patients, String> patientSurname;
    @FXML
    private TableColumn<Patients, String> patientAge;
    @FXML
    private TextArea getPatientDiagnosis;
    @FXML
    private Button regPatientBtn;
    @FXML
    private Button backBtn;


//    ObservableList<Patients> oblist = FXCollections.observableArrayList();

    public void PatientData(ActionEvent e)  {

//          String selectPatients = "SELECT id, first_name, second_name, day_of_birth FROM hospital_db.patients";
//          String selectPatients = "SELECT * FROM hospital_db.patients";
//
//            Connection connection = getDbConnection();
//            ObservableList <Patients> patients = FXCollections.observableArrayList();
//            //  data = FXCollections.observableArrayList();
//            ResultSet rs = connection.createStatement().executeQuery(selectPatients);
//
//            while (rs.next()){
//                oblist.add(new Patients(rs.getInt("id"), rs.getString("first_name"), rs.getString("second_name"), rs.getString("day_of_birth")));
//            }
//
//        patientID.setCellValueFactory(new PropertyValueFactory<>("id"));
//        patientName.setCellValueFactory(new PropertyValueFactory<>("firstName1"));
//        patientSurname.setCellValueFactory(new PropertyValueFactory<>("lastName1"));
//        patientAge.setCellValueFactory(new PropertyValueFactory<>("dayOfBirth1"));
//
//
//
//        getPatientTable.setItems(oblist);










        pateintReloadDB.setOnAction(actionEvent -> {

            try {
                getPatient();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            //            onEdit();


//                onEdit();
        });

//        if (getPatientTable.getSelectionModel().getSelectedItem() != null) {
//            Patients selectedPatient = (Patients) getPatientTable.getSelectionModel().getSelectedItem();
//            patientID.setText(String.valueOf(selectedPatient.getId()));
//            patientName.setText(selectedPatient.getFirstName());
//            patientSurname.setText(selectedPatient.getLastName());
//            patientAge.setText(selectedPatient.getDayOfBirth());
//
//
//
//        }

    }

    public void setPatientsData(ActionEvent e) throws IOException {
        //Close current
        Stage stage = (Stage) regPatientBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registrationPat.fxml"));
        Parent root1 = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registration Form");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setResizable(false);

    }

    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://abul.db.elephantsql.com:5432/ckkttdhb", "ckkttdhb", "nozrUH1mHHpvvm8s9L_JPAgb1bm14w20");

//        String connectionString = "jdbc:postgresql://" + dbHost + ":"
//                + dbPort + "/" + dbName;
//
//
//        Class.forName("org.postgres.Driver");
//        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
//        return dbConnection;
    }


    public void getPatient() throws SQLException, ClassNotFoundException {
//        String selectPatients = "SELECT id, first_name, second_name, day_of_birth FROM hospital_db.patients";
////        String selectPatients = "SELECT * FROM hospital_db.patients";
//        try {
//            Connection connection = getDbConnection();
//           final ObservableList<Patients> patients = FXCollections.observableArrayList();
//            //  data = FXCollections.observableArrayList();
//            ResultSet rs = connection.createStatement().executeQuery(selectPatients);
//
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String first_name = rs.getString("first_name");
//                String second_name = rs.getString("second_name");
//                String day_of_birth = rs.getString("day_of_birth");
//
//                patients.add(new Patients(id, first_name, second_name, day_of_birth));
//            }
//
//            TableColumn<Patients, String> id = new TableColumn<>("ID");
//            id.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
//
//            TableColumn<Patients, String> name = new TableColumn<>("Name");
//            name.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//
//            TableColumn<Patients, String> surname = new TableColumn<>("Last Name");
//            surname.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
//
//
//            TableColumn<Patients, String> age = new TableColumn<>("Day Of Birth");
//            age.setCellValueFactory(cellData -> cellData.getValue().dayOfBirthProperty());
//
//
//            getPatientTable.getColumns().addAll(id, name, surname, age);
//            getPatientTable.setColumnResizePolicy(getPatientTable.CONSTRAINED_RESIZE_POLICY);
//            getPatientTable.setItems(patients);
////            getPatientTable.getItems().clear();
//
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


//        String selectPatients = "SELECT * FROM hospital_db.patients";
//        try {
//            Connection connection = getDbConnection();
//            ObservableList<Patients> patients = FXCollections.observableArrayList();
//            //  data = FXCollections.observableArrayList();
//            ResultSet rs = connection.createStatement().executeQuery(selectPatients);
//
//
//        }
    }

    public void getDataFromDB(ActionEvent actionEvent) {
        String selectPatients = "SELECT id, first_name, second_name, day_of_birth FROM hospital_db.patients";
//        String selectPatients = "SELECT * FROM hospital_db.patients";
        try {
            Connection connection = getDbConnection();
            final ObservableList<Patients> patients = FXCollections.observableArrayList();
            //  data = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery(selectPatients);

            while (rs.next()) {
                String id = rs.getString("id");
                String first_name = rs.getString("first_name");
                String second_name = rs.getString("second_name");
                String day_of_birth = rs.getString("day_of_birth");

                patients.add(new Patients(id, first_name, second_name, day_of_birth));
            }

            TableColumn<Patients, String> id = new TableColumn<>("ID");
            id.setCellValueFactory(cellData -> cellData.getValue().IDProperty());

            TableColumn<Patients, String> name = new TableColumn<>("Name");
            name.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

            TableColumn<Patients, String> surname = new TableColumn<>("Last Name");
            surname.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());


            TableColumn<Patients, String> age = new TableColumn<>("Day Of Birth");
            age.setCellValueFactory(cellData -> cellData.getValue().dayOfBirthProperty());


            getPatientTable.getColumns().addAll(id, name, surname, age);
            getPatientTable.setColumnResizePolicy(getPatientTable.CONSTRAINED_RESIZE_POLICY);
            getPatientTable.setItems(patients);



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void Reload(ActionEvent actionEvent) {
        getPatientTable.getItems().clear();
        getPatientTable.getColumns().clear();
        getDataFromDB(actionEvent);

    }
    public void Search(ActionEvent actionEvent) {
    }

    public void Update(ActionEvent actionEvent) {
    }

    @FXML
    private TextField nameText1;
    @FXML
    private TextField surnameText1;
    public void Delete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = getDbConnection();
        String selectPatients = "DELETE from hospital_db.patients where id =?  ";
        PreparedStatement pst;
        try {
//            getPatientTable.getItems().removeAll(getPatientTable.getSelectionModel().getSelectedItem());

            pst = connection.prepareStatement(selectPatients);
//            pst.setString(1, nameText1.getText());
            pst.setString(1, nameText1.getText());
            pst.execute();
            getDataFromDB(actionEvent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //PATIENTS ADD
//----------------------------------------------------------------------------------------------------------------------
    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField dateOfBirth;
    @FXML
    private TextField diagnosisText;
    @FXML
    private Button patientAdd;
    public void addPatients (String setFirstName, String setLastName, String setDayOfBirth, String setDiagnosis) {
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
//------------------------------------------------------------------------------------------------------------------------------------

    public void addPatient(ActionEvent actionEvent) {
        MainWindow mainWindow = new MainWindow();
        patientAdd.setOnAction(ActionEvent -> {
            if(nameText.getText().matches("\\d+")||nameText.getText().equals("")) {
                infoBox("Registration not Successfull, \nPlease, enter the Name. \nUse characters only.", "Warning", null);
            } else if (surnameText.getText().matches("\\d+") ||surnameText.getText().equals("")) {
                infoBox("Registration not Successfull,  \nPlease, enter the Surname \nUse characters only.", "Warning", null);
            } else if (dateOfBirth.getText().matches("[a-zA-Z]+") || dateOfBirth.getText().equals("")) {
                infoBox("Registration not Successfull,   \nPlease, enter right DOB \nMust contains only numbers \nFormat (dd/mm/yyyy) or (dd.mm.yyyy)", "Warning", null);
            } else if (diagnosisText.getText().equals("")) {
                infoBox("Registration not Successfull,   \nPlease, enter Diagnosis", "Success", null);
            }else {
                mainWindow.addPatients(nameText.getText(), surnameText.getText(), dateOfBirth.getText(), diagnosisText.getText());
                infoBox("Registration Successfull", "Success", null);
            }
        });

    }
    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
//----------------------------------------------------------------------------------------------------------------------


//---------------------------------------------------------------------------------------------------------------------------------------------
//    public void getPatient() throws SQLException, ClassNotFoundException {
//        String selectPatients = "SELECT id, first_name,second_name,day_of_birth FROM hospital_db.patients";
//        try {
//            Connection connection = getDbConnection();
//            data = FXCollections.observableArrayList();
//            ResultSet rs = connection.createStatement().executeQuery(selectPatients);
//
//            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                //We are using non property style for making dynamic table
//                final int j = i;
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
//
//                getPatientTable.getColumns().addAll(col);
//                getPatientTable.setColumnResizePolicy(getPatientTable.CONSTRAINED_RESIZE_POLICY);
//
////                System.out.println("Column [" + i + "] ");
//            }
//            while (rs.next()) {
//                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//                    //Iterate Column
//                    row.add(rs.getString(i));
//                }
////                System.out.println("Row [1] added " + row);
//                data.addAll(row);
//            }
//
//            //FINALLY ADDED TO TableView
//            getPatientTable.setItems(data);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error on Building Data");
//        }
//    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------


//    public void onEdit(){
//
//     if (getPatientTable.getSelectionModel().getSelectedItem() != null) {
//         Patients selectedPatient = (Patients) getPatientTable.getSelectionModel().getSelectedItem();
//         patientID.setText(String.valueOf(selectedPatient.getId()));
//         patientName.setText(selectedPatient.getFirstName1());
//         patientSurname.setText(selectedPatient.getLastName1());
//         patientAge.setText(selectedPatient.getDayOfBirth1());
//
//
//     }
//    }


//        Connection connection = getDbConnection();
//        data = FXCollections.observableArrayList();
//
////        ObservableList<String> row = FXCollections.observableArrayList();
////        try{
////            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM hospital_db.patients  where id =? AND first_name =? AND second_name =? AND day_of_birth =?");
////            ResultSet rs = preparedStatement.executeQuery();
////            while(rs.next()) {
////                row.add(String.valueOf(new Patients(Integer.parseInt(rs.getString("ID")), rs.getString("Name"), rs.getString("Surname"), rs.getString("Age"))));
////
////            }
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        }
//
//        try {
////            String selectPatients = "SELECT * FROM hospital_db.patients";
//            String selectPatients = "SELECT id, first_name, second_name, day_of_birth FROM hospital_db.patients";
//
////            String selectDiagnosis = "SELECT diagnosis FROM hospital_db.patients";
////            ResultSet rsDiagnosis = c.createStatement().executeQuery(selectDiagnosis);
//
//
//            ResultSet rs = connection.createStatement().executeQuery(selectPatients);
//            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                //We are using non property style for making dynamic table
//                final int j = i;
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
//
//                getPatientTable.getColumns().addAll(col);
//
//
//            }
//            while (rs.next()) {
//                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//                    //Iterate Column
//                    row.add(rs.getString(i));
//
//                }
//                data.add(row);
//            }
//            getPatientTable.getItems().clear();
//
//            getPatientTable.getItems().addAll(data);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    }





