package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.Set;

@ApplicationScoped
public class PraxisManager {

    @Inject
    private EntityManager entityManager;

    public void addTherapeut(Therapeut therapeut, long id){
        Praxis pr = getPraxisById(id);
        Set<Therapeut> therapeutList= pr.getTherapeuts();
        therapeutList.add(therapeut);
        pr.setTherapeuts(therapeutList);
        save(pr);
    }

    public boolean removeTherapeut(Therapeut therapeut, long id){
        Praxis pr = getPraxisById(id);
        if(pr.getTherapeuts().contains(therapeut)){
            Set<Therapeut> therapeutList = pr.getTherapeuts();
            therapeutList.remove(therapeut);
            pr.setTherapeuts(therapeutList);
            save(pr);
            return true;
        }
        return false;
    }

    public void renamePraxis(String name, long id){
        Praxis pr = getPraxisById(id);
        pr.setName(name);
        save(pr);
    }

    public void save(Praxis praxis) {
        entityManager.persist(praxis);
    }

    private Praxis getPraxisById(long id){
        Praxis pr = entityManager.find(Praxis.class,id);
        return pr;
    }



}
