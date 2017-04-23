package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.ProgrammExponent;
import java.util.List;

@ApplicationScoped
public class ProgrammManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public Programm createProgramm(String name){
        Programm programm = new Programm(name);
        entityManager.persist(programm);
        return programm;
    }

    @Transactional
    public Programm createProgramm(String name, List<ProgrammExponent> programmExponents){
        Programm programm = new Programm(name, programmExponents);
        save(programm);
        return programm;
    }

    @Transactional
    public Programm addExercise(Programm programm, Exercise exercise, int reps, int sets){
        programm.getProgrammExponents().add(new ProgrammExponent(exercise, sets, reps));
        save(programm);
        return programm;
    }

    @Transactional
    public void save(Programm programm) {
        entityManager.persist(programm);
    }

    @Transactional
    public boolean removeProgrammExponentByExercise(Programm programm, Exercise exercise){
        List<ProgrammExponent> programmExponents = programm.getProgrammExponents();
        boolean successWithDeletion = false;
        for (ProgrammExponent exp : programmExponents) {
            if (exp.getExercise().getId() == exercise.getId()) {
                programmExponents.remove(exp);
                successWithDeletion = true;
            }
        }
        save(programm);
        return successWithDeletion;
    }

    @Transactional
    public boolean removeProgrammExponent(Programm programm, ProgrammExponent programmExponent){
        List<ProgrammExponent> programmExponents = programm.getProgrammExponents();
        if(programmExponents.contains(programmExponent)){
            programmExponents.remove(programmExponent);
            save(programm);
            return true;
        }
        return false;
    }

    @Transactional
    private Programm getProgrammById(long id) throws Exception {
        if(entityManager.find(Programm.class, id)!=null)
            return entityManager.find(Programm.class, id);
        else throw new Exception();

    }

    @Transactional
    private List<Programm> getProgrammsByName(String name) throws Exception {
        TypedQuery<Programm> query = entityManager.createQuery("SELECT p FROM Programm p WHERE p.programm_name = :name", Programm.class);
        return query.getResultList();
    }

    @Transactional
    private ProgrammExponent getProgrammExponentById(long id) throws Exception{
        if(entityManager.find(Programm.class, id)!=null)
            return entityManager.find(ProgrammExponent.class, id);
        else throw new Exception();
    }

}

