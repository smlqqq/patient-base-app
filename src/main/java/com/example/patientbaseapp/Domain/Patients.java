package com.example.patientbaseapp.Domain;

import javafx.beans.property.SimpleStringProperty;

public class Patients {

    private int id;
    private SimpleStringProperty ID;
    private SimpleStringProperty  firstName;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private SimpleStringProperty  lastName;
    private SimpleStringProperty  dayOfBirth;
    private SimpleStringProperty  diagnosis;

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
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

    public Patients(String id, String first_name, String second_name, String day_of_birth, String diagnosis) {
        this.ID = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(first_name);
        this.lastName = new SimpleStringProperty(second_name);
        this.dayOfBirth = new SimpleStringProperty(day_of_birth);
        this.diagnosis = new SimpleStringProperty(diagnosis);
    }


//
//    public Patients(int ID, String firstName, String lastName, String dayOfBirth) {
//        this.ID = new SimpleIntegerProperty(ID);
//        this.firstName = new SimpleStringProperty(firstName);
//        this.lastName = new SimpleStringProperty(lastName);
//        this.dayOfBirth = new SimpleStringProperty(dayOfBirth);
//    }
//
//    public int getID() {
//        return ID.get();
//    }
//
//    public SimpleIntegerProperty IDProperty() {
//        return ID;
//    }
//
//    public void setID(int ID) {
//        this.ID.set(ID);
//    }
//
//    public String getFirstName() {
//        return firstName.get();
//    }
//
//    public SimpleStringProperty firstNameProperty() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName.set(firstName);
//    }
//
//    public String getLastName() {
//        return lastName.get();
//    }
//
//    public SimpleStringProperty lastNameProperty() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName.set(lastName);
//    }
//
//    public String getDayOfBirth() {
//        return dayOfBirth.get();
//    }
//
//    public SimpleStringProperty dayOfBirthProperty() {
//        return dayOfBirth;
//    }
//
//    public void setDayOfBirth(String dayOfBirth) {
//        this.dayOfBirth.set(dayOfBirth);
//    }
//
//    public String getDiagnosis() {
//        return diagnosis.get();
//    }
//
//    public SimpleStringProperty diagnosisProperty() {
//        return diagnosis;
//    }
//
//    public void setDiagnosis(String diagnosis) {
//        this.diagnosis.set(diagnosis);
//    }
}
