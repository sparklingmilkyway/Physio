package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.List;
import java.util.Set;
/**
 * All Operations including Database queries for the Patient class are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */
@ApplicationScoped
public class PatientManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;


    @Transactional
    public List<Programm> getProgrammsOfAPatient(Patient patient){
        TypedQuery<Programm> query = entityManager.createQuery("SELECT p FROM Programm p WHERE p.patient = :patient", Programm.class);
        return query.getResultList();
    }

    @Transactional
    public Patient createNewPatient(Therapeut therapeut, String patientSurname, String patientFirstname){
        Patient patient = new Patient(patientSurname, patientFirstname, therapeut);
        save(patient);
        return patient;
    }

    @Transactional
    public void save(Patient patient) {
        entityManager.persist(patient);
    }

    @Transactional
    public boolean removePatient(Patient patient){
        if(entityManager.find(Patient.class, patient.getId())!=null) {
            entityManager.remove(patient);
            return true;
        }
        else return false;
    }
    @Transactional
    public Patient getPatientById(long id){
        return entityManager.find(Patient.class, id);
    }

   /* @Transactional
    public List<Patient> getPatientsBySurname(String name){
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p WHERE p.surname = :name", Patient.class);
        return query.getResultList();
    }*/

}
