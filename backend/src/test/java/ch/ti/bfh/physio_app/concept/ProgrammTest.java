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