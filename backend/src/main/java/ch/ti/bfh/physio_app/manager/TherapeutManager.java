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

    public void remove(Therapeut therapeut){
        entityManager.remove(therapeut);
    }

    @Transactional
    private Therapeut getTherapeutById(long id){
        return entityManager.find(Therapeut.class, id);
    }

    @Transactional
    private List<Therapeut> getTherapeutBySurname(long id){
        TypedQuery<Therapeut> query = entityManager.createQuery("SELECT t FROM Therapeut t WHERE t.surname = :name", Therapeut.class);
        return query.getResultList();

    }


}
