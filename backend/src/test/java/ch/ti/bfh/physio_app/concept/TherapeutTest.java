package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 05.04.2017.
 */
public class TherapeutTest {
    @Test
    public void getPatientList() throws Exception {
        Therapeut therapeut = new Therapeut("John","Doe","12345");

        assertNotNull(therapeut.getPatientList());
    }

    @Test
    public void setPatientList() throws Exception {
        Therapeut therapeut = new Therapeut("John","Doe","12345");

        Patient patient = new Patient();
        Patient patient1 = new Patient();

        Set<Patient> patientSet = new HashSet<Patient>();
        patientSet.add(patient);
        patientSet.add(patient1);

        therapeut.setPatientList(patientSet);

        assertEquals(therapeut.getPatientList(),patientSet);
    }
}