package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

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
public class PraxisManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public void save(Praxis praxis) {
        entityManager.persist(praxis);
    }


    /*  // used, when more than one praxis in the DB
    @Transactional
    public Praxis getPraxisById(long id){
        return entityManager.find(Praxis.class,id);
    }
    */

    @Transactional
    public Praxis getPraxis(){
        TypedQuery<Praxis> query = entityManager.createQuery("SELECT p FROM Praxis p", Praxis.class);
        return query.getSingleResult();
    }


    // parameter "long praxisId" is only used, when more than one praxis in the DB
    @Transactional
    public List<Therapeut> getTherapeuts(/* long praxisId */){
        // used, when more than one praxis in the DB
        // TypedQuery<Therapeut> query = entityManager.createQuery("SELECT t FROM Therapeut t WHERE t.praxis.id = :praxisId", Therapeut.class);
        // query.setParameter("praxisId", praxisId);

        TypedQuery<Therapeut> query = entityManager.createQuery("SELECT t FROM Therapeut t", Therapeut.class);
        return query.getResultList();
    }

}
