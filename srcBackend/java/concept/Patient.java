package java.concept;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Vanessa on 19.03.17.
 */
public class Patient extends pEntityWithID{

    private String surname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "id")
    private Therapeut therapeut;

    @ManyToOne
    @JoinColumn(name = "id")
    private Set<Programm> programms = new HashSet<Programm>();

    /** TO KEEP HIBERNATE HAPPY */
    public Patient(){

    }

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

    public Set<Programm> getProgramms() {
        return programms;
    }

    public void setProgramms(Set<Programm> programm) {
        this.programms = programms;
    }
}
