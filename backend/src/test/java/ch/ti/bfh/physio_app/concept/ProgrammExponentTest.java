package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 05.04.2017.
 */
public class ProgrammExponentTest {
    @Test
    public void getExercise() throws Exception {
        Exercise exercise = new Exercise("exercise","back");
        Exercise exercise1 = new Exercise("exercise", "back");

        ProgrammExponent programmExponent = new ProgrammExponent(exercise,3,12);

        assertNotEquals(programmExponent.getExercise(),exercise1);
        assertEquals(programmExponent.getExercise(),exercise);
    }

    @Test
    public void setExercise() throws Exception {
        Exercise exercise = new Exercise("exercise","back");
        Exercise exercise1 = new Exercise("exercise", "back");

        ProgrammExponent programmExponent = new ProgrammExponent(exercise,3,12);

        programmExponent.setExercise(exercise1);
        assertEquals(programmExponent.getExercise(),exercise1);
    }

    @Test
    public void getReps() throws Exception {
        Exercise exercise = new Exercise("exercise","back");

        ProgrammExponent programmExponent = new ProgrammExponent(exercise,3,12);

        assertEquals(programmExponent.getReps(),12);
    }

    @Test
    public void setReps() throws Exception {
        Exercise exercise = new Exercise("exercise","back");

        ProgrammExponent programmExponent = new ProgrammExponent(exercise,3,12);

        programmExponent.setReps(14);

        assertEquals(programmExponent.getReps(),14);
        assertNotEquals(programmExponent.getReps(),12);
    }

    @Test
    public void getSets() throws Exception {
        Exercise exercise = new Exercise("exercise","back");

        ProgrammExponent programmExponent = new ProgrammExponent(exercise,3,12);

        assertEquals(programmExponent.getSets(),3);
    }

    @Test
    public void setSets() throws Exception {
        Exercise exercise = new Exercise("exercise","back");

        ProgrammExponent programmExponent = new ProgrammExponent(exercise,3,12);

        programmExponent.setSets(4);

        assertEquals(programmExponent.getSets(),4);
        assertNotEquals(programmExponent.getSets(),3);
    }
}