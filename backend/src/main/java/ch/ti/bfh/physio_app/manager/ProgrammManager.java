package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.*;
import java.util.List;
/**
 * All Operations including Database queries for the Programm class are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */
@ApplicationScoped
public class ProgrammManager {

    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public void save(Programm programm) {
        entityManager.persist(programm);
    }

    @Transactional
    public void save(ProgrammComponent programmComponent) {
        entityManager.persist(programmComponent);
    }

    @Transactional
    public Programm addProgrammExponentToProgramm(Programm programm, Exercise exercise, int reps, int sets){
        ProgrammComponent programmComponent = new ProgrammComponent(exercise, programm, sets, reps);
        save(programmComponent);
        programm.getProgrammComponent().add(programmComponent);
        save(programm);
        return programm;
    }


    @Transactional
    public List<Programm> getAllProgramms(){
        TypedQuery<Programm> query = entityManager.createQuery("SELECT p FROM Programm p", Programm.class);
        return query.getResultList();

    }

    @Transactional
    public Programm getProgrammById(long id){
        TypedQuery<Programm> query = entityManager.createQuery("SELECT p FROM Programm p WHERE p.id= :id", Programm.class);
        return query.getSingleResult();

    }

    @Transactional
    public boolean removeProgrammComponent(ProgrammComponent programmComponent){
            if (entityManager.contains(programmComponent)) {
                entityManager.remove(programmComponent);
                // Programm programm = programmComponent.getProgramm();
                // programm.getProgrammComponent().remove(programmComponent);
                // save(programm);

                return true;
            }
            return false;

        }

    @Transactional
    public boolean removeProgrammExponentByExercise(Programm programm, Exercise exercise){
        List<ProgrammComponent> programmComponents = programm.getProgrammComponent();
        boolean successWithDeletion = false;
        for (ProgrammComponent component : programmComponents) {
            if (component.getExercise().getId() == exercise.getId()) {
                // programmComponents.remove(component);
                entityManager.remove(component);
                successWithDeletion = true;
            }
        }
        save(programm);
        return successWithDeletion;
    }


    @Transactional
    private List<Programm> getProgrammsByName(String name) throws Exception {
        TypedQuery<Programm> query = entityManager.createQuery("SELECT p FROM Programm p WHERE p.programm_name = :name", Programm.class);
        query.setParameter("name", name);
        return query.getResultList();

    }

    @Transactional
    private List<ProgrammComponent> getProgrammComponentsByProgramm(long programmId) {
        TypedQuery<ProgrammComponent> query = entityManager.createQuery("SELECT p FROM ProgrammComponent p WHERE p.programm.id = :programmId", ProgrammComponent.class);
        query.setParameter("programmId", programmId);
        return query.getResultList();
    }

}

