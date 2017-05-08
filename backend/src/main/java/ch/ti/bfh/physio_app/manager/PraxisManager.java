package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.Set;
/**
 * All Operations including Database queries for the Praxis class are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */
@ApplicationScoped
public class PraxisManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public Praxis addTherapeut(Praxis praxis, Therapeut therapeut){
        praxis.getTherapeuts().add(therapeut);
        save(praxis);
        return praxis;
    }

    @Transactional
    public boolean removeTherapeut(Praxis praxis, Therapeut therapeut) {
        if (praxis.getTherapeuts().contains(therapeut)) {
            praxis.getTherapeuts().remove(therapeut);
            save(praxis);
            return true;
        } else return false;
    }

    @Transactional
    public void save(Praxis praxis) {
        entityManager.persist(praxis);
    }

    @Transactional
    private Praxis getPraxisById(long id){
        return entityManager.find(Praxis.class,id);
    }



}
