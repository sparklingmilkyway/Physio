package java.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.concept.Exercise;

/**
 * Created by Vanessa on 19.03.17.
 */
public class ExerciseManager {

    // private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
    private EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


    public void AddNote(String note){
        //notes.add(note);
    }

    public boolean RemoveNote(String note){
       /** for(String n : this.notes){
            if(n.equals(note)){
                notes.remove(n);
                return true;
            }
        }*/
        return false;

    }

    public void addNote(Exercise ex, String note){

    }

    public Exercise getExe(Exercise ex, String note){

    }


    public Exercise newExercise(String name,String type) {
        Exercise ex = new Exercise();
        ex.setName(name);
        ex.setType(type);
        save(ex);
    }

    public void save(Exercise ex) {
        em.persist(ex);
    }




    public void test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1")
        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


        // Work with the EM
        em.close();

        emf.close(); //close at application end

    }
}
