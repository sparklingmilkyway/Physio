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
        Therapeut therapeut = new Therapeut("Peter","Pan","12345");
        Patient patient = new Patient("John","Doe",therapeut);
        assertEquals(patient.getTherapeut(),therapeut);
    }

    @Test
    public void setTherapeut() throws Exception {
        Therapeut therapeut = new Therapeut("Peter", "Pan", "12345");
        Therapeut therapeut1 = new Therapeut("Elon", "Musk", "hackalbe");
        Patient patient = new Patient("John", "Doe", therapeut);
        assertEquals(patient.getTherapeut(), therapeut);
        patient.setTherapeut(therapeut1);
        assertEquals(patient.getTherapeut(), therapeut1);
    }

    @Test
    public void setProgramms(){
        Set<Programm> programmlist = new HashSet<Programm>();

        Programm programm = new Programm();
        Programm programm1 = new Programm();

        programmlist.add(programm);
        programmlist.add(programm1);

        Therapeut therapeut = new Therapeut("Peter", "Pan", "12345");

        Patient patient = new Patient("Peter","Pan",therapeut);
        patient.setProgramms(programmlist);
        assertNotNull(patient.getProgramms());
    }

    @Test
    public void getProgramms(){
        Set<Programm> programmlist = new HashSet<Programm>();

        Programm programm = new Programm();
        Programm programm1 = new Programm();

        programmlist.add(programm);
        programmlist.add(programm1);

        Therapeut therapeut = new Therapeut("Peter", "Pan", "12345");

        Patient patient = new Patient("Peter","Pan",therapeut);
        patient.setProgramms(programmlist);
        assertEquals(patient.getProgramms(),programmlist);
    }

    @Test
    public void getSurname(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John",therapeut);

        assertEquals(patient.getSurname(),"Doe");
    }

    @Test
    public void getLastName(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John",therapeut);

        assertEquals(patient.getLastname(),"John");
    }

    @Test
    public void setSurname(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John",therapeut);
        patient.setSurname("Peter");

        assertEquals(patient.getSurname(),"Peter");
    }

    @Test
    public void setLastname(){
        Therapeut therapeut = new Therapeut();

        Patient patient = new Patient("Doe","John",therapeut);
        patient.setLastname("Pan");

        assertEquals(patient.getLastname(),"Pan");
    }
}