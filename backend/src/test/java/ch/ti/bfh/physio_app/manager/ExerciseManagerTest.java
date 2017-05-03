package ch.ti.bfh.physio_app.manager;

import ch.ti.bfh.physio_app.concept.ExerciseNote;
import org.junit.Test;
import ch.ti.bfh.physio_app.concept.Exercise;

import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by Jonas on 03.05.2017.
 */
public class ExerciseManagerTest {
    @Test
    public void save() throws Exception {
        Exercise ex = new Exercise();
        ExerciseManager exm = new ExerciseManager();
        exm.save(ex);
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