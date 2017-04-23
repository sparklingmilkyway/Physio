package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 05.04.2017.
 */
public class ExerciseTest {
    @Test
    public void getName() throws Exception {
        Exercise exercise = new Exercise("stretching","Back");
        assertNotNull(exercise.getName());

        Exercise exercise1 = new Exercise();
        assertNull(exercise1.getName());
    }

    @Test
    public void setName() throws Exception {
        Exercise exercise = new Exercise("stretching","Back");
        exercise.setName("liverStretch");
        assertEquals(exercise.getName(),"liverStretch");
    }

    @Test
    public void getType() throws Exception {
        Exercise exercise = new Exercise("stretching","Back");
        assertNotNull(exercise.getType());

        Exercise exercise1 = new Exercise();
        assertNull(exercise1.getType());
    }

    @Test
    public void setType() throws Exception {
        Exercise exercise = new Exercise("stretching","Back");
        exercise.setType("liverStretch");
        assertEquals(exercise.getType(),"liverStretch");
    }

    @Test
    public void getNotes() throws Exception {
        Exercise exercise = new Exercise("stretching","Back");
        assertNotNull(exercise.getNotes());
    }

}