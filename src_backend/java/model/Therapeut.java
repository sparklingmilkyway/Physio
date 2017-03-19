package java.model;

import java.util.ArrayList;
import java.util.List;

public class Therapeut {
    private String surname;
    private String lastname;
    //we should change the data type for PW later...
    private String password;
    private int id;
    private List<Patient> patientList;

    public Therapeut(String surname, String lastname, int id, String password){
        this.surname = surname;
        this.lastname = lastname;
        this.id = id;
        this.password = password;
        patientList = new ArrayList<Patient>();
    }

    public String getName() {
        return (this.surname+this.lastname);
    }

    public List getPatients(){
        return this.patientList;
    }

    public void addPatient(Patient patient){
        if(patientList.contains(patient)){
            return;
        }
        patientList.add(patient);
    }

    public boolean removePatient(Patient patient){
        if(patientList.contains(patient)){
            patientList.remove(patient);
            return true;
        }
        return false;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean addExercise(String name, String type){
        Exercise e;
        e = new Exercise(name, type);
        /*We'll need some persistence manager later which adds the exercise to the DB*/
        return true;
    }

    public boolean removeExercise(String name, String type){
         /*We'll need some persistence manager later which removes the exercise to the DB*/
        return true;
    }
}