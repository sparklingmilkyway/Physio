package ch.ti.bfh.physio_app.concept;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Therapeut extends pEntityWithID{

    @Column
    private String firstname;
    @Column
    private String surname;
    @Column(unique=true)
    private String email;
    @Column
    private String passwordHash;
   // @ManyToOne
   // private Praxis praxis;


    /** TO KEEP HIBERNATE HAPPY */
    public Therapeut(){

    }

    public Therapeut(String firstname, String surname, String email, String passwordHash) {
        this.surname = surname;
        this.firstname = firstname;
        this.email = email;
        this.passwordHash = passwordHash;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /*
    public Praxis getPraxis() {
        return praxis;
    }

    public void setPraxis(Praxis praxis) {
        this.praxis = praxis;
    }
    */
}