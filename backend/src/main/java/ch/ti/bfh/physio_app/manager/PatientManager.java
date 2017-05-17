package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.List;
import java.util.Set;
/**
 * All Operations including Database queries for the Praxis class are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */
@ApplicationScoped
public class PatientManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public void save(Patient patient) {
        entityManager.persist(patient);
    }

    @Transactional
    public Patient getPatientById(long id){
        return entityManager.find(Patient.class,id);
    }

    @Transactional
    public Therapeut getTherapeut(Patient patient){
        long id = patient.getId();
        TypedQuery<Therapeut> query = entityManager.createQuery("SELECT p FROM Patient p WHERE p.therapeut.id = :id", Therapeut.class);
        return query.getSingleResult();
    }

    public List<Patient> getPatientBySurname(String surname){
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p WHERE p.surname =:surname", Patient.class);
        return query.getResultList();
    }

    public List<Patient> getAllPatients(){
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p", Patient.class);
        return query.getResultList();
    }
}

