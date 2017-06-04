package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.List;
import java.util.Set;
/**
 * All Operations including Database queries for the Therapeut class are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */

@ApplicationScoped
public class TherapeutManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public List<Patient> getPatientList(Therapeut therapeut, Patient patient){
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p WHERE p.therapeut = :therapeut", Patient.class);
        return query.getResultList();
    }

    @Transactional
    public void save(Therapeut therapeut) {
        entityManager.persist(therapeut);
    }

    @Transactional
    public void remove(Therapeut therapeut){
        entityManager.remove(therapeut);
    }

    @Transactional
    public Therapeut getTherapeutById(long id){
        return entityManager.find(Therapeut.class, id);
    }


    @Transactional
    private List<Therapeut> getTherapeutBySurname(String name){
        TypedQuery<Therapeut> query = entityManager.createQuery("SELECT t FROM Therapeut t WHERE t.surname = :name", Therapeut.class);
        query.setParameter("name", name);
        return query.getResultList();

    }

    // update an therapeut
    @Transactional
    public Therapeut update(Therapeut therapeutToUpdate, Therapeut therapeut){
        therapeutToUpdate.setEmail(therapeut.getEmail());
        therapeutToUpdate.setFirstname(therapeut.getFirstname());
        therapeutToUpdate.setSurname(therapeut.getSurname());
        save(therapeutToUpdate);
        return therapeutToUpdate;
    }

    @Transactional
    public List<Therapeut> getTherapeuts(){
        TypedQuery<Therapeut> query = entityManager.createQuery("SELECT t FROM Therapeut t", Therapeut.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(long id){
        entityManager.remove(getTherapeutById(id));
    }

    @Transactional
    public Therapeut getTherapeutByEmail(String email){
        TypedQuery<Therapeut> query = entityManager.createQuery("SELECT t FROM Therapeut t WHERE t.email = :email", Therapeut.class);
        query.setParameter("email", email);
        return query.getSingleResult();

    }

}
