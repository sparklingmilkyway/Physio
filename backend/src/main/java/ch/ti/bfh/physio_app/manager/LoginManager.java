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
public class LoginManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;
/*
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
*/
}
