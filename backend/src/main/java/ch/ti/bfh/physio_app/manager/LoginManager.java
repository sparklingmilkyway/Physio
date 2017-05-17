package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.*;

import java.util.List;
import java.util.Set;

/**
 * All Operations including Database queries for the Login are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */

@ApplicationScoped
public class LoginManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;



    public String doHash(String pwToHash){
        //DO HASHING HERE
        return pwToHash;
    }





}
