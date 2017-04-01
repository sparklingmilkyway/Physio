package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import concept.Exercise;
import concept.Patient;
import concept.Praxis;
import concept.Therapeut;
import java.util.List;
import java.util.Set;

/**
 * Created by Vanessa on 19.03.17.
 */
public class TherapeutManager {

    //private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
    private EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager

    public void addPatient(Patient patient, long id){
        Therapeut te = getTherapeutById(id);
        Set<Patient> patientList = te.getPatientList();
        patientList.add(patient);
        te.setPatientList(patientList);
        save(te);
    }

    public boolean removePatient(Patient patient, long id){
        Therapeut te = getTherapeutById(id);
        Set<Patient> patientSet = te.getPatientList();
        if(patientSet.contains(patient)) {
            patientSet.remove(patient);
            te.setPatientList(patientSet);
            save(te);
            return true;
        }
        return false;
    }

    //chönnte mr die methode nid grad la si? chame ja mit de getter&setter regle
    public void changePasswordHash(String passwordHash, long id){
        Therapeut te = getTherapeutById(id);
        te.setPasswordHash(passwordHash);
        save(te);
    }

    // chönnte mr die Methode nid grad lasi? chame ja mit de getter&setter regle
    public String getPasswordHash(long id){
        Therapeut te = getTherapeutById(id);
        return te.getPasswordHash();
    }

    //oh hie gits sicher no e besseri lösig...
    public void createExercise(String name, String type){
        Exercise exercise = new Exercise(name,type);
        saveExercise(exercise);
    }

    public void removeExercise(long id){
            Exercise ex = getExerciseById(id);
            remove(ex);
    }

    public void save(Therapeut therapeut) {
        em.persist(therapeut);
    }

    public void remove(Exercise exercise){
        em.remove(exercise);
    }

    public void saveExercise(Exercise exercise){
        em.persist(exercise);
    }

    private Therapeut getTherapeutById(long id){
        Therapeut te = em.find(Therapeut.class,id);
        return te;
    }

    private Exercise getExerciseById(long id){
        Exercise ex = em.find(Exercise.class, id);
        return ex;
    }

    public void test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


        // Work with the EM
        em.close();

        emf.close(); //close at application end

    }



}
