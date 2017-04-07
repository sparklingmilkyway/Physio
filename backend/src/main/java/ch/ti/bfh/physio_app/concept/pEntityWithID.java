package ch.ti.bfh.physio_app.concept;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Every Component of our concept will inherit this abstract class. The pEntityWithID class is to give each object an
 * automatic generated unique key(datatype=long).
 * */
@Entity
public abstract class pEntityWithID implements pEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}