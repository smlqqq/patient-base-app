package com.example.patientbaseapp.Domain;

import javafx.beans.property.StringProperty;

public class Patinets {
    private String ID;
    private StringProperty firstName;
    private StringProperty  lastName;
    private StringProperty  dayOfBirth;
    private StringProperty  diagnosis;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public Patinets(String ID, StringProperty firstName, StringProperty lastName, StringProperty dayOfBirth, StringProperty diagnosis) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.diagnosis = diagnosis;
    }
}
