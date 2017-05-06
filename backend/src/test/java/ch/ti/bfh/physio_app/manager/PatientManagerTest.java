package ch.ti.bfh.physio_app.manager;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.Therapeut;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 06.05.2017.
 * Important! Since we use Junit on this level of testing, we can't actually check what will happen in the real programm later.
 * We can only check if the desired method of our EntityManger is called and how many times. Nevertheless it is a good way to test
 * the behaviour of our methods.
 *
 * If desired, we will test on another level with another test environment.
 */
public class PatientManagerTest {

    private PatientManager cut;
    private EntityManager mockedEntityMangager = Mockito.mock(EntityManager.class);

    @Before
    public void setup() throws Exception {
        cut = new PatientManager();

        // If entity manager would be public, cut.entityManager = mockedEntityManager would be possible
        // Load field from class
        Field entityManager = cut.getClass().getDeclaredField("entityManager");

        // Allow access to private fields
        entityManager.setAccessible(true);

        // set entityManager Variable of cut to mocked EntityManager
        entityManager.set(cut, mockedEntityMangager);
    }

    @Test
    public void save() throws Exception{
        Patient pt = new Patient();
        cut.save(pt);
    }

    @Test
    public void getProgrammsOfAPatient() throws Exception {

        /*
        Patient pt  = new Patient();
        cut.getProgrammsOfAPatient(pt);
        Mockito.verify(mockedEntityMangager, Mockito.times(1)).createQuery(
                "SELECT p FROM Programm p WHERE p.patient = :patient", Programm.class);
        */
    }

    @Test
    public void createNewPatient() throws Exception {
        Therapeut tp = new Therapeut();
        Patient pt = cut.createNewPatient(tp, "JOHN", "DOE");
        Mockito.verify(mockedEntityMangager, Mockito.times(1)).persist(pt);
    }

    @Test
    public void removePatient() throws Exception {
        Patient pt = new Patient();
        cut.removePatient(pt);
        /*
        The .remove() method from the EntityManager won't be called, since there will never be an object found
         */
        Mockito.verify(mockedEntityMangager, Mockito.times(0)).remove(pt);

        assertFalse(cut.removePatient(pt));
    }

    @Test
    public void getPatientById() throws Exception {
        Patient pt = new Patient();
        cut.getPatientById(pt.getId());

        Mockito.verify(mockedEntityMangager, Mockito.times(1)).find(Patient.class, pt.getId());
    }

    @Test
    public void getPatientsBySurname() throws Exception {
        /*
        Patient pt = new Patient();
        pt.setSurname("John");
        cut.getPatientsBySurname("John");

        Mockito.verify(mockedEntityMangager, Mockito.times(1)).createQuery(
                "SELECT p FROM Patient p WHERE p.surname = :name", Patient.class);
    */
    }

}