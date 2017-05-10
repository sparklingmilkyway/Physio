package ch.ti.bfh.physio_app.concept;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 05.04.2017.
 */
public class PraxisTest {
    @Test
    public void getName() throws Exception {
        Praxis praxis = new Praxis("Praxis");
        assertNotNull(praxis.getName());
        assertEquals(praxis.getName(),"Praxis");
    }

    @Test
    public void setName() throws Exception {
        Praxis praxis = new Praxis("Praxis");
        assertEquals(praxis.getName(),"Praxis");
        praxis.setName("Praxis2");
        assertEquals(praxis.getName(),"Praxis2");
    }

    /*@Test
    public void getTherapeuts() throws Exception {
        Praxis praxis = new Praxis("Praxis");
        assertNotNull(praxis.getTherapeuts());
    }

    @Test
    public void setTherapeuts() throws Exception {
        Praxis praxis = new Praxis("Praxis");

        Therapeut therapeut = new Therapeut();
        Therapeut therapeut1 = new Therapeut(new Praxis("praxis"),"John","Doe","12345");

        Set<Therapeut> therapeutSet = new HashSet<Therapeut>();
        therapeutSet.add(therapeut);
        therapeutSet.add(therapeut1);

        praxis.setTherapeuts(therapeutSet);

        assertEquals(praxis.getTherapeuts(),therapeutSet);
    }*/

}