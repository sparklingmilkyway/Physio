package ch.ti.bfh.physio_app.concept;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Vanessa on 19.03.17.
 */

/**
 * This class describes the attributes and functionality of a Patient. An Patient can have exactly one Therapeut.
 * A Therapeut can have mutliple Patients.Attention! Deleting the default constructor
 * will corrupt the junit tests.
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
        //Programm placeholder = new Programm();
        //this.programms.add(placeholder);
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

    /**
     * Right now a Patient has a whole set Of Programms. If desired form the Customer, we can change this to exactly one
     * Programm.Attention! Changing from a Set to a Programm Object will corrupt the junit tests.
     *
     */
    public void setProgramms(Set<Programm> programms) {
        this.programms = programms;
    }
}
