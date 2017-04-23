package ch.ti.bfh.physio_app.concept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class describes the attributes and function of a Praxis.
 */
@Entity
public class Praxis extends pEntityWithID{

    @Column
    private String name;

    @OneToMany
    @Column
    private Set<Therapeut> therapeuts = new HashSet<>();

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