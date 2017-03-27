package java.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.concept.Exercise;
import java.util.List;

/**
 * Created by Vanessa on 19.03.17.
 */
public class ExerciseManager {

    // private EntityManager entityManager = new EntityManager();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
    private EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


    public void AddNote(String note, Exercise exercise){
        Exercise ex = getExerciseById(exercise.getId());
        List<String> notes = ex.getNotes();
        notes.add(note);
        ex.setNotes(notes);
        save(ex);
    }

    public boolean RemoveNote(String note, Exercise exercise){
        Exercise ex = getExerciseById(exercise.getId());
        List<String> notes = ex.getNotes();
        for(String n: notes){
            if(n.equals(note)){
                notes.remove(note);
                ex.setNotes(notes);
                save(ex);
                return true;
            }
        }
        return false;
    }

    public Exercise getExe(String note, Exercise exercise){
        //Was söu die Methode genau chönne?
        return exercise;
    }

    public void newExercise(String name,String type) {
        Exercise ex = new Exercise();
        ex.setName(name);
        ex.setType(type);
        save(ex);
    }

    public void save(Exercise ex) {
        em.persist(ex);
    }

    private Exercise getExerciseById(long id){
        Exercise ex = em.find(Exercise.class,id);
        return ex;
    }

    public void test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager


        // Work with the EM
        em.close();

        emf.close(); //close at application end

    }
}
