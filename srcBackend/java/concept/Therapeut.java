package java.concept;

import java.util.HashSet;
import java.util.Set;

public class Therapeut extends User{

    private Set<Patient> patientList;

    /** TO KEEP HIBERNATE HAPPY */
    public Therapeut(){

    }

    public Therapeut(String surname, String lastname, String passwordHash){
        this.setSurname(surname);
        this.setLastname(lastname);
        this.setPasswordHash(passwordHash);
        patientList = new HashSet<Patient>();
    }


    public Set<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(Set<Patient> patientList) {
        this.patientList = patientList;
    }
}