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
    public Patient(){ }

    public Patient(String surname, String firstname, String email, String passwordhash, Therapeut therapeut){
        super(surname, firstname, email,passwordhash);
        this.therapeut = therapeut;
    }

    public Therapeut getTherapeut() {
        return therapeut;
    }

    public void setTherapeut(Therapeut therapeut) {
        this.therapeut = therapeut;
    }

}
