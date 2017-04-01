package ch.ti.bfh.physio_app.concept;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Vanessa on 19.03.17.
 */

public class Patient extends User{


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
        this.setSurname(surname);
        this.setLastname(lastname);
        this.therapeut = therapeut;
        Programm placeholder = new Programm();
        this.programms.add(placeholder);
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
