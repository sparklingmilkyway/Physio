package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 05.04.2017.
 */
public class ProgrammExponentTest {
    @Test
    public void getExercise() throws Exception {
        Exercise exercise = new Exercise( "exercise","back",new Therapeut());
        Exercise exercise1 = new Exercise("exercise", "back", new Therapeut());
        Programm programm = new Programm("program");
        ProgrammComponent programmComponent = new ProgrammComponent(exercise, programm, 3,12);

        assertNotEquals(programmComponent.getExercise(),exercise1);
        assertEquals(programmComponent.getExercise(),exercise);
    }

    @Test
    public void setExercise() throws Exception {
        Exercise exercise = new Exercise("exercise","back", new Therapeut());
        Exercise exercise1 = new Exercise("exercise", "back", new Therapeut());
        Programm programm = new Programm("program");
        ProgrammComponent programmComponent = new ProgrammComponent(exercise, programm, 3,12);

        programmComponent.setExercise(exercise1);
        assertEquals(programmComponent.getExercise(),exercise1);
    }

    @Test
    public void getReps() throws Exception {
        Exercise exercise = new Exercise("exercise","back", new Therapeut());
        Programm programm = new Programm("program");
        ProgrammComponent programmComponent = new ProgrammComponent(exercise, programm, 3,12);

        assertEquals(programmComponent.getReps(),12);
    }

    @Test
    public void setReps() throws Exception {
        Exercise exercise = new Exercise("exercise","back", new Therapeut());
        Programm programm = new Programm("program");
        ProgrammComponent programmComponent = new ProgrammComponent(exercise, programm, 3,12);

        programmComponent.setReps(14);

        assertEquals(programmComponent.getReps(),14);
        assertNotEquals(programmComponent.getReps(),12);
    }

    @Test
    public void getSets() throws Exception {
        Exercise exercise = new Exercise("exercise","back", new Therapeut());
        Programm programm = new Programm("program");
        ProgrammComponent programmComponent = new ProgrammComponent(exercise, programm, 3,12);

        assertEquals(programmComponent.getSets(),3);
    }

    @Test
    public void setSets() throws Exception {
        Exercise exercise = new Exercise("exercise","back", new Therapeut());
        Programm programm = new Programm("program");
        ProgrammComponent programmComponent = new ProgrammComponent(exercise, programm, 3,12);

        programmComponent.setSets(4);

        assertEquals(programmComponent.getSets(),4);
        assertNotEquals(programmComponent.getSets(),3);
    }
}