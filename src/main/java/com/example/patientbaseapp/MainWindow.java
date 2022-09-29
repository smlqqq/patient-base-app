package com.example.patientbaseapp;

import com.example.patientbaseapp.DB.Handler;
import com.example.patientbaseapp.Domain.Patients;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.*;
import java.util.Locale;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

public class MainWindow extends Handler {

    private ObservableList<ObservableList> data;
    private ObservableList<Patients> DB = FXCollections.observableArrayList();

    @FXML
    private TableView getPatientTable;
    @FXML
    private TableColumn<Patients, String> patientID;
    @FXML
    private TableColumn<Patients, String> patientName;
    @FXML
    private TableColumn<Patients, String> patientSurname;
    @FXML
    private TableColumn<Patients, String> patientAge;
    @FXML
    private TableColumn<Patients, String> patientDiagnosis;
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
    @FXML
    private TextField nameText1;
    @FXML
    private TextField surnameText1;
    @FXML
    private TextField idText;
    @FXML
    private TextField diagnosisText1;
    @FXML
    private TextField dobText;
    @FXML
    private TextField searchField;

    PreparedStatement pst;
    ResultSet rs;
    Connection dbConnection;
    int index = -1;


    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://abul.db.elephantsql.com:5432/ckkttdhb", "ckkttdhb", "nozrUH1mHHpvvm8s9L_JPAgb1bm14w20");

    }

    public void getDataFromDB(ActionEvent actionEvent) {
        String selectPatients = "SELECT * FROM hospital_db.patients";
        try {

            dbConnection = getDbConnection();
            final ObservableList<Patients> patients = FXCollections.observableArrayList();
            rs = dbConnection.createStatement().executeQuery(selectPatients);

            while (rs.next()) {
                String id = rs.getString("id");
                String first_name = rs.getString("first_name");
                String second_name = rs.getString("second_name");
                String day_of_birth = rs.getString("day_of_birth");
                String diagnosis = rs.getString("diagnosis");

                patients.add(new Patients(id, first_name, second_name, day_of_birth, diagnosis));

            }

            patientID = new TableColumn<>("ID");
            patientID.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
            patientID.setVisible(false);

            patientName = new TableColumn<>("Name");
            patientName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

            patientSurname = new TableColumn<>("Last Name");
            patientSurname.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

            patientAge = new TableColumn<>("Date Of Birth(Age)");
            patientAge.setCellValueFactory(cellData -> cellData.getValue().dayOfBirthProperty());

            patientDiagnosis = new TableColumn<>("Diagnosis");
            patientDiagnosis.setCellValueFactory(cellData -> cellData.getValue().diagnosisProperty());
            patientDiagnosis.setVisible(false);

            getPatientTable.getColumns().addAll(patientID, patientName, patientSurname, patientAge, patientDiagnosis);
            getPatientTable.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
            getPatientTable.setItems(patients);

            dbConnection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUpdate(){
        patientID.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        patientName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        patientSurname.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        patientAge.setCellValueFactory(cellData -> cellData.getValue().dayOfBirthProperty());
        patientDiagnosis.setCellValueFactory(cellData -> cellData.getValue().diagnosisProperty());
        DB = getDBPatients();
        getPatientTable.setItems(DB);
    }

    public void Reload(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        getPatientTable.getItems().clear();
        getPatientTable.getColumns().clear();
        getDataFromDB(actionEvent);
    }

    public void Search() throws SQLException, ClassNotFoundException {
        
        patientID.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        patientName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        patientSurname.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        patientAge.setCellValueFactory(cellData -> cellData.getValue().dayOfBirthProperty());
        patientDiagnosis.setCellValueFactory(cellData -> cellData.getValue().diagnosisProperty());

        DB = getDBPatients();
        getPatientTable.setItems(DB);

        FilteredList <Patients> filteredList = new FilteredList<>(DB, b->true);
        searchField.textProperty().addListener((observable ,oldValue, newValue) -> {
            filteredList.setPredicate(patients -> {

                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFltr = newValue.toLowerCase(Locale.ROOT);

                if(patients.getFirstName().toLowerCase().contains(lowerCaseFltr)){
                    return true;

                } else if (patients.getLastName().contains(lowerCaseFltr))
                    return true;
                    else
                        return false;

            });
        });

        SortedList<Patients>patientsSortedList=new SortedList<>(filteredList);
        patientsSortedList.comparatorProperty().bind(getPatientTable.comparatorProperty());
        getPatientTable.setItems(patientsSortedList);

    }

    public  ObservableList<Patients> getDBPatients() {
        final ObservableList<Patients> patients = FXCollections.observableArrayList();
        try {

            PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM hospital_db.patients");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String id = rs.getString("id");
                String first_name = rs.getString("first_name");
                String second_name = rs.getString("second_name");
                String day_of_birth = rs.getString("day_of_birth");
                String diagnosis = rs.getString("diagnosis");

                patients.add(new Patients(id, first_name, second_name, day_of_birth, diagnosis));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }



    public void Update(ActionEvent actionEvent) {
        try {
            dbConnection = getDbConnection();
            String id = patientID.getText();
            String name = patientName.getText();
            String surname = patientSurname.getText();
            String diagnosis = patientDiagnosis.getText();

//            String setSelect = "UPDATE hospital_db.patients set first_name = " + name + ",second_name= " + surname+ ",diagnosis= " + diagnosis;
            String setSelect = "UPDATE hospital_db.patients set diagnosis= " + diagnosis;
            pst = dbConnection.prepareStatement(setSelect);
            pst.execute();
            Reload(actionEvent);
            Search();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void Delete(ActionEvent actionEvent) throws ClassNotFoundException {

        String selectPatients = "DELETE from hospital_db.patients where id =?";
        try {

            pst = dbConnection.prepareStatement(selectPatients);
            pst.setInt(1, Integer.parseInt(idText.getText()));
            pst.execute();
            infoBox("Row deleted", "Succes", null);
            Reload(actionEvent);
            Search();

//            pst.execute();
//            getDataFromDB(actionEvent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //PATIENTS ADD


    public void addPatients(String setFirstName, String setLastName, String setDayOfBirth, String setDiagnosis) {
        String setSelect = "insert into hospital_db.patients (first_name,second_name,day_of_birth,diagnosis)VALUES (?,?,?,?)";

        try {
            pst = getDbConnection().prepareStatement(setSelect);
            pst.setString(1, setFirstName);
            pst.setString(2, setLastName);
            pst.setString(3, setDayOfBirth);
            pst.setString(4, setDiagnosis);
            pst.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {    }
    }

    public void addPatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        MainWindow mainWindow = new MainWindow();

            if (nameText.getText().matches("\\d+") || nameText.getText().equals("")) {
                infoBox("Registration not Successfull, \nPlease, enter the Name. \nUse characters only.", "Warning", null);
            } else if (surnameText.getText().matches("\\d+") || surnameText.getText().equals("")) {
                infoBox("Registration not Successfull,  \nPlease, enter the Surname \nUse characters only.", "Warning", null);
            } else if (dateOfBirth.getText().matches("[a-zA-Z]+") || dateOfBirth.getText().equals("")) {
                infoBox("Registration not Successfull,   \nPlease, enter right DOB \nMust contains only numbers \nFormat (dd/mm/yyyy) or (dd.mm.yyyy)", "Warning", null);
            } else if (diagnosisText.getText().equals("")) {
                infoBox("Registration not Successfull,   \nPlease, enter Diagnosis", "Success", null);
            } else {
                mainWindow.addPatients(nameText.getText(), surnameText.getText(), dateOfBirth.getText(), diagnosisText.getText());
                infoBox("Registration Successfull", "Success", null);
            }

            Reload(actionEvent);

    }



    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {

        index = getPatientTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idText.setText(patientID.getCellData(index));
        nameText1.setText(patientName.getCellData(index));
        surnameText1.setText(patientSurname.getCellData(index));
        dobText.setText(patientAge.getCellData(index));
        diagnosisText1.setText(patientDiagnosis.getCellData(index));

    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

}







