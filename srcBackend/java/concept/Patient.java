package java.concept;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Vanessa on 19.03.17.
 */
public class Patient extends pEntityWithID{

    private String surname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "id")
    private Therapeut therapeut;
    private Programm programm;

    public Patient(String surname, String lastname, Therapeut therapeut){
        this.surname = surname;
        this.lastname = lastname;
        this.therapeut = therapeut;
        this.programm = new Programm("Placeholder");
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

    public Therapeut getTherapeut() {
        return therapeut;
    }

    public void setTherapeut(Therapeut therapeut) {
        this.therapeut = therapeut;
    }

    public Programm getProgramm() {
        return programm;
    }

    public void setProgramm(Programm programm) {
        this.programm = programm;
    }
}
