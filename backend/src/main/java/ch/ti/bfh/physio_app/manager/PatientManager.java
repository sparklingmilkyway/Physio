package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.Therapeut;
import java.util.Set;

@ApplicationScoped
public class PatientManager {

    @Inject
    private EntityManager entityManager;


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
        entityManager.persist(ex);
    }

    private Patient getPatientById(long id){
        Patient pa = entityManager.find(Patient.class,id);
        return pa;
    }

}
