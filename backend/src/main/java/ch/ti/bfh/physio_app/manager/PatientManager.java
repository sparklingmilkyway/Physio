package ch.ti.bfh.physio_app.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.Therapeut;
import java.util.Set;

/**
 * Created by Vanessa on 19.03.17.
 */
public class PatientManager {

    // private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
    private EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


    public String getTherapeut(Patient patient){
        Patient pa = getPatientById(patient.getId());
        Therapeut te = pa.getTherapeut();
        return te.getSurname()+" "+te.getLastname();
    }

    public void addProgramm(Programm programm,long id){
        Patient pa = getPatientById(id);
        Set<Programm> programmList = pa.getProgramms();
        programmList.add(programm);
        pa.setProgramms(programmList);
        save(pa);
    }

    public void removeProgramm(Programm programm,long id){
        Patient pa = getPatientById(id);
        Set<Programm> programmList = pa.getProgramms();
        programmList.remove(programm);
        pa.setProgramms(programmList);
        save(pa);
    }

    public void changeTherapeut(Therapeut therapeut, long id){
        Patient pa = getPatientById(id);
        pa.setTherapeut(therapeut);
        save(pa);
    }

    /*
    public void addExercise(Exercise exercise){
        if(exerciseList.contains(exercise)){
            return;
        }
        exerciseList.add(exercise);
    }

    public void removeExercise(Exercise exercise){
        if(exerciseList.contains(exercise)){
            exerciseList.remove(exercise);
        }
        return;
    }

    public List getExercises(){
        return this.exerciseList;
    }
    */

    public void save(Patient ex) {
        em.persist(ex);
    }

    private Patient getPatientById(long id){
        Patient pa = em.find(Patient.class,id);
        return pa;
    }

    public void test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


        // Work with the EM
        em.close();

        emf.close(); //close at application end

    }
}
