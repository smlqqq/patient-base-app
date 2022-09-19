package com.example.patientbaseapp.Domain;

import javafx.beans.property.StringProperty;

public class Patients {
    private Integer ID;
    private StringProperty firstName;
    private StringProperty  lastName;
    private StringProperty  dayOfBirth;
    private StringProperty  diagnosis;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getDayOfBirth1() {
        return dayOfBirth1;
    }

    public void setDayOfBirth1(String dayOfBirth1) {
        this.dayOfBirth1 = dayOfBirth1;
    }

    private int Id;
    private String firstName1;
    private String lastName1;
    private String dayOfBirth1;

    public Patients(Integer patID, String patName, String patSurName, String patDOB) {
        this.Id = patID;
        this.firstName1 = patName;
        this.lastName1 = patSurName;
        this.dayOfBirth1 = patDOB;
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

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getDayOfBirth() {
        return dayOfBirth.get();
    }

    public StringProperty dayOfBirthProperty() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth.set(dayOfBirth);
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public StringProperty diagnosisProperty() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }

//    public Patients(Integer ID, StringProperty firstName, StringProperty lastName, StringProperty dayOfBirth, StringProperty diagnosis) {
//        this.ID = ID;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dayOfBirth = dayOfBirth;
//        this.diagnosis = diagnosis;
//    }
}
