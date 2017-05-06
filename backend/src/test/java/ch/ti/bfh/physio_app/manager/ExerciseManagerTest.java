package ch.ti.bfh.physio_app.manager;

import ch.ti.bfh.physio_app.concept.ExerciseNote;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ch.ti.bfh.physio_app.concept.Exercise;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;
import org.mockito.Mockito;

/*
 * Created by Jonas on 03.05.2017.
 */
public class ExerciseManagerTest {

    private ExerciseManager cut;
    private EntityManager mockedEntityMangager = Mockito.mock(EntityManager.class);

    @Before
    public void setup() throws Exception {
        cut = new ExerciseManager();




        // If entity manager would be public, cut.entityManager = mockedEntityManager would be possible
        // Load field from class
        Field entityManager = cut.getClass().getDeclaredField("entityManager");

        // Allow access to private fields
        entityManager.setAccessible(true);

        // set entityManager Variable of cut to mocked EntityManager
        entityManager.set(cut, mockedEntityMangager);
    }

    @Test
    public void save() throws Exception {
        Exercise ex = new Exercise();
        cut.save(ex);
        //Has implicit assert statement
        Mockito.verify(mockedEntityMangager, Mockito.times(1)).persist(ex);
    }

    @Test
    public void getExerciseById() throws Exception {
        Exercise ex = new Exercise();
        ExerciseManager exm = new ExerciseManager();
        exm.save(ex);
        /*Exercise ex2 = exm.getExerciseById(ex.getId());
        assertEquals(ex.getId(),ex2.getId());*/
    }

    @Test
    public void addNote() throws Exception {
        Exercise ex = new Exercise();
        ExerciseManager exm = new ExerciseManager();
        exm.addNote("Hallo Welt", ex);
        List arrayList = ex.getNotes();
        int arrayListLength = arrayList.size();
        assertEquals(ex.getNotes().get(arrayListLength),"Hallo welt");
    }

    @Test
    public void removeNote() throws Exception {
        Exercise ex = new Exercise();
        ExerciseManager exm = new ExerciseManager();
        ExerciseNote exn = new ExerciseNote("Hallo Welt",ex);
        exm.addNote(exn, ex);
        exm.removeNote(exn,ex);
        assertNotEquals(exm.getNote(ex,exn),exn);
    }

    @Test
    public void newExercise() throws Exception {
    }

    @Test
    public void removeExercise() throws Exception {
    }

}