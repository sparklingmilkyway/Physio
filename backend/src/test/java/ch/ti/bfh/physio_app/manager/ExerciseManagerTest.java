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
 * Important! Since we use Junit on this level of testing, we can't actually check what will happen in the real programm later.
 * We can only check if the desired method of our EntityManger is called and how many times. Nevertheless it is a good way to test
 * the behaviour of our methods.
  *
  * If desired, we will test on another level with another test environment.
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
        cut.save(ex);
        cut.getExerciseById(ex.getId());
        Mockito.verify(mockedEntityMangager, Mockito.times(1)).find(Exercise.class, ex.getId());
        cut.getExerciseById(ex.getId());
        Mockito.verify(mockedEntityMangager, Mockito.times(2)).find(Exercise.class, ex.getId());
    }

    @Test
    public void addNote() throws Exception {
        Exercise ex = new Exercise();
        cut.addNote("Hallo Welt", ex);
        Mockito.verify(mockedEntityMangager, Mockito.times(1)).persist(ex);

        /*
        List arrayList = ex.getNotes();
        int arrayListLength = arrayList.size();
        assertEquals(ex.getNotes().get(arrayListLength),"Hallo welt");
        */
    }

    @Test
    public void removeNote() throws Exception {
        Exercise ex = new Exercise();
        ExerciseNote exn = new ExerciseNote();
        cut.removeNote(exn, ex);
        // persist will be called zero times, since the entityManager function will only be called if there is
        // actually Something to remove. Since we work with a mocked Object, this will never be the case
        Mockito.verify(mockedEntityMangager, Mockito.times(0)).persist(ex);

        //Since there is no such note entry in the arrayList, the method will return false.
        assertFalse(cut.removeNote(exn, ex));

        /*Exercise ex = new Exercise();
        ExerciseManager exm = new ExerciseManager();
        ExerciseNote exn = new ExerciseNote("Hallo Welt",ex);
        exm.addNote(exn, ex);
        exm.removeNote(exn,ex);
        assertNotEquals(exm.getNote(ex,exn),exn);*/

    }

    @Test
    public void newExercise() throws Exception {
        Exercise ex = cut.newExercise("EX", "back");

        Mockito.verify(mockedEntityMangager, Mockito.times(1)).persist(ex);

        /*
        The Exercise Object has already been tested, so we can trust this class
         */
    }

    @Test
    public void removeExercise() throws Exception {
        Exercise ex = new Exercise();
        cut.removeExercise(ex);

        Mockito.verify(mockedEntityMangager, Mockito.times(1)).contains(ex);
        /*
        The .remove() method from the EntityManager won't be called, since there will never be an object found
         */
        Mockito.verify(mockedEntityMangager, Mockito.times(0)).remove(ex);

        assertFalse(cut.removeExercise(ex));
    }

}