package ch.ti.bfh.physio_app.concept;

import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;


public class ExerciseManagerTest extends JPAHibernateTest {

    @Test
    public void testGetExerciseById_success() {
        Exercise ex = em.find(Exercise.class, 1);
        assertNotNull(ex);
    }


}