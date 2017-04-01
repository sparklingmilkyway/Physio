package ch.ti.bfh.physio_app.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.ProgrammExponent;
import java.util.List;

public class ProgrammManager {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
    private EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager

    public void addExercise(ProgrammExponent programmExponent, int sets, int reps, long id){
        Programm pr = getProgrammById(id);
        List<ProgrammExponent> exerciseList = pr.getExerciseList();
        exerciseList.add(programmExponent);
        pr.setExerciseList(exerciseList);
        save(pr);
    }

    public boolean removeProgrammExponentByExercise(Exercise exercise, long id){

        //Hie bini mr nid sicher obi di richtig verstande ha mit de Exponente

        Programm pr = getProgrammById(id);
        List<ProgrammExponent> programmExponentList = pr.getExerciseList();

        for(int i = 0; i <= programmExponentList.size(); i++){
            if(programmExponentList.get(i).equals(exercise)){
                programmExponentList.remove(i);
                pr.setExerciseList(programmExponentList);
                save(pr);
                return true;
            }
        }
        return false;
    }

    public boolean removeProgrammExponent(ProgrammExponent exercise, long id){
        Programm pr = getProgrammById(id);
        List<ProgrammExponent> programmExponentList = pr.getExerciseList();
        if(programmExponentList.contains(exercise)){
            programmExponentList.remove(exercise);
            pr.setExerciseList(programmExponentList);
            save(pr);
            return true;
        }
        return false;
    }

    public void save(Programm programm) {
        em.persist(programm);
    }

    private Programm getProgrammById(long id){
        Programm pr = em.find(Programm.class,id);
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

