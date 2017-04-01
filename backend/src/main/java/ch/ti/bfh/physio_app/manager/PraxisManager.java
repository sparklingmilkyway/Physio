package ch.ti.bfh.physio_app.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;

import java.util.Set;

/**
 * Created by Vanessa on 19.03.17.
 */
public class PraxisManager {

    // private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
    private EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager

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
        em.persist(praxis);
    }

    private Praxis getPraxisById(long id){
        Praxis pr = em.find(Praxis.class,id);
        return pr;
    }

    public void test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


        // Work with the EM
        em.close();

        emf.close(); //close at application end

    }


}
