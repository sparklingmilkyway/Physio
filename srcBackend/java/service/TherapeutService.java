package java.service;

import java.concept.Exercise;
import java.concept.Patient;

/**
 * Created by Vanessa on 19.03.17.
 */
public class TherapeutService {

    private EntityManager entityManager = new EntityManager();

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

    public void changePasswordHash(String passwordHash){
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash(){
        return this.passwordHash;
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
