package com.example.patientbaseapp.Domain;

import javafx.beans.property.SimpleStringProperty;

public class Patients {

    private final SimpleStringProperty ID;
    private final SimpleStringProperty  firstName;
    private final SimpleStringProperty  lastName;
    private final SimpleStringProperty  dayOfBirth;
    private final SimpleStringProperty  diagnosis;



    public SimpleStringProperty diagnosisProperty() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public SimpleStringProperty dayOfBirthProperty() {
        return dayOfBirth;
    }

    public Patients(String id, String first_name, String second_name, String day_of_birth, String diagnosis) {
        this.ID = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(first_name);
        this.lastName = new SimpleStringProperty(second_name);
        this.dayOfBirth = new SimpleStringProperty(day_of_birth);
        this.diagnosis = new SimpleStringProperty(diagnosis);
    }
}
