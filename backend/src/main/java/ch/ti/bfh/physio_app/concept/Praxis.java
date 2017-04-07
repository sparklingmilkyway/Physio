package ch.ti.bfh.physio_app.concept;

import java.util.HashSet;
import java.util.Set;

/**
 * This class describes the attributes and function of a Praxis.
 */
public class Praxis extends pEntityWithID{

    private String name;
    private Set<Therapeut> therapeuts;

    /** TO KEEP HIBERNATE HAPPY */
    public Praxis(){

    }

    public Praxis(String name){
        this.name = name;
        therapeuts = new HashSet<Therapeut>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Therapeut> getTherapeuts() {
        return therapeuts;
    }

    public void setTherapeuts(Set<Therapeut> therapeutSet){
        this.therapeuts = therapeutSet;
    }
}