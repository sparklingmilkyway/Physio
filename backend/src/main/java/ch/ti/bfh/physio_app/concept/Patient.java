package ch.ti.bfh.physio_app.concept;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * This class describes the attributes and functionality of a Patient. An Patient can have exactly one Therapeut.
 * A Therapeut can have mutliple Patients.Attention! Deleting the default constructor
 * will corrupt the junit tests.
 */
@Entity
public class Patient extends pEntityWithID {


    @Column
    private String surname;
    @Column
    private String firstname;
    @Column
    private String email;
    @ManyToOne
    private Therapeut therapeut;


    /** TO KEEP HIBERNATE HAPPY */
    public Patient(){ }

    public Patient(String firstname, String surname, String email, Therapeut therapeut) {
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.therapeut = therapeut;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Therapeut getTherapeut() {
        return therapeut;
    }

    public void setTherapeut(Therapeut therapeut) {
        this.therapeut = therapeut;
    }

}
