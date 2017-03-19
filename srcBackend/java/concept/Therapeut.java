package java.concept;

import java.util.HashSet;
import java.util.Set;

public class Therapeut extends pEntityWithID {
    private String surname;
    private String lastname;
    private String passwordHash;
    private int id;
    private Set<Patient> patientList;

    public Therapeut(String surname, String lastname, int id, String passwordHash){
        this.surname = surname;
        this.lastname = lastname;
        this.id = id;
        this.passwordHash = passwordHash;
        patientList = new HashSet<Patient>();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Set<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(Set<Patient> patientList) {
        this.patientList = patientList;
    }
}