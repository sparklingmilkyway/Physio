package ch.ti.bfh.physio_app.concept;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Therapeut extends User{


    @ManyToOne
    private Praxis praxis;


    /** TO KEEP HIBERNATE HAPPY */
    public Therapeut(){

    }

    public Therapeut(Praxis praxis, String surname, String lastname, String passwordHash){
        this.setSurname(surname);
        this.setFirstname(lastname);
        this.setPasswordHash(passwordHash);
        this.praxis = praxis;
    }

    public Praxis getPraxis() {
        return praxis;
    }

    public void setPraxis(Praxis praxis) {
        this.praxis = praxis;
    }
}