package java.model;

import java.util.HashSet;
import java.util.Set;

public class Praxis extends pEntityWithID{

    private String name;
    private Set<Therapeut> therapeuts;

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

    public void setTherapeuts(Set<Therapeut> therapeuts) {
        this.therapeuts = therapeuts;
    }
}