package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 05.04.2017.
 */
public class ProgrammTest {
    @Test
    public void getExerciseList() throws Exception {
        Programm programm = new Programm("Programm");
        assertNotNull(programm.getExerciseList());
    }

    @Test
    public void setExerciseList() throws Exception {
        Programm programm = new Programm("Programm");
        List<ProgrammExponent> programmExponentList = new ArrayList<ProgrammExponent>();

        ProgrammExponent programmExponent = new ProgrammExponent();
        ProgrammExponent programmExponent1 = new ProgrammExponent();

        programmExponentList.add(programmExponent);
        programmExponentList.add(programmExponent1);
        programm.setExerciseList(programmExponentList);

        assertEquals(programm.getExerciseList(),programmExponentList);
        assertSame(programm.getExerciseList(),programmExponentList);

        for(int i=0;i<programmExponentList.size();i++) {
            assertSame(programm.getExerciseList().get(i), programmExponentList.get(i));
        }
    }

    @Test
    public void getName() throws Exception {
        Programm programm = new Programm("Programm");
        assertNotNull(programm.getName());
        assertEquals(programm.getName(),"Programm");
    }

    @Test
    public void setName() throws Exception {
        Programm programm = new Programm("Programm");
        assertEquals(programm.getName(),"Programm");

        programm.setName("ProgrammNew");
        assertNotEquals(programm.getName(),"Programm");
        assertEquals(programm.getName(),"ProgrammNew");
    }

}