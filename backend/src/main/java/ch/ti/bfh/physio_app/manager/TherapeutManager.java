package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.Set;


@ApplicationScoped
public class TherapeutManager {

    @Inject
    private EntityManager entityManager;

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
        entityManager.persist(therapeut);
    }

    public void remove(Exercise exercise){
        entityManager.remove(exercise);
    }

    public void saveExercise(Exercise exercise){
        entityManager.persist(exercise);
    }

    private Therapeut getTherapeutById(long id){
        Therapeut te = entityManager.find(Therapeut.class,id);
        return te;
    }

    private Exercise getExerciseById(long id){
        Exercise ex = entityManager.find(Exercise.class, id);
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
