package ch.ti.bfh.physio_app.concept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
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

    /** TO KEEP HIBERNATE HAPPY */
    public Praxis(){

    }

    public Praxis(String name){
        this.name = name;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}