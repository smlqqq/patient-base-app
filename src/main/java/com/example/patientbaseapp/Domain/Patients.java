package com.example.patientbaseapp.Domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patients {
    private Integer ID;
    private SimpleStringProperty firstName;
    private SimpleStringProperty  lastName;
    private SimpleStringProperty  dayOfBirth;
    private SimpleStringProperty  diagnosis;

    public Patients(Integer ID, String firstName, String lastName, String dayOfBirth) {
        this.ID = ID;
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.dayOfBirth = new SimpleStringProperty(dayOfBirth);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getDayOfBirth() {
        return dayOfBirth.get();
    }

    public SimpleStringProperty dayOfBirthProperty() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth.set(dayOfBirth);
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public SimpleStringProperty diagnosisProperty() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }
}
