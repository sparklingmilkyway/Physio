package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 01.04.2017.
 */
public class PatientTest {
    @Test
    public void getTherapeut() throws Exception {
        Therapeut therapeut = new Therapeut(new Praxis("praxis"),"Peter","Pan", "email@email.ch","12345");
        Patient patient = new Patient("John","Doe", "email@email", "pwhash", therapeut);
        assertEquals(patient.getTherapeut(),therapeut);
    }

    @Test
    public void setTherapeut() throws Exception {
        Therapeut therapeut = new Therapeut(new Praxis("praxis"),"Peter", "Pan", "email@email.ch", "12345");
        Therapeut therapeut1 = new Therapeut(new Praxis("praxis"),"Elon", "Musk", "email@email.ch", "hackalbe");
        Patient patient = new Patient("John", "Doe", "email@email", "pwhash",  therapeut);
        assertEquals(patient.getTherapeut(), therapeut);
        patient.setTherapeut(therapeut1);
        assertEquals(patient.getTherapeut(), therapeut1);
    }



    @Test
    public void getSurname(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John", "email@email", "pwhash",  therapeut);

        assertEquals(patient.getSurname(),"Doe");
    }

    @Test
    public void getLastName(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John", "email@email", "pwhash",  therapeut);

        assertEquals(patient.getFirstname(),"John");
    }

    @Test
    public void setSurname(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John", "email@email", "pwhash", therapeut);
        patient.setSurname("Peter");

        assertEquals(patient.getSurname(),"Peter");
    }

    @Test
    public void setLastname(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John", "email@email", "pwhash",  therapeut);
        patient.setFirstname("Pan");

        assertEquals(patient.getFirstname(),"Pan");
    }
}