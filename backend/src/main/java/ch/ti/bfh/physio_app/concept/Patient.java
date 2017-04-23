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
public class Patient extends User{

    @ManyToOne
    private Therapeut therapeut;

    /** TO KEEP HIBERNATE HAPPY */
    public Patient(){

    }

    public Patient(String surname, String firstname, Therapeut therapeut){
        this.setSurname(surname);
        this.setFirstname(firstname);
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

}
