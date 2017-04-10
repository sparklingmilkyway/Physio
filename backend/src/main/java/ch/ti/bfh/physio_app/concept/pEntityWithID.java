package ch.ti.bfh.physio_app.concept;

import javax.persistence.*;

/**
 * Every Component of our concept will inherit this abstract class. The pEntityWithID class is to give each object an
 * automatic generated unique key(datatype=long).
 * */
@Entity
public abstract class pEntityWithID implements pEntity {
    @Id /* @Id declares the identifier property of this entity. */
    @GeneratedValue(strategy=GenerationType.AUTO) /* @GeneratedValue annotation is used to specify the primary key generation strategy to use. If the strategy is not specified by default AUTO will be used. */
    @Column(name = "ID") /* @Column annotation is used to specify the details of the column to which a field or property will be mapped. If the @Column annotation is not specified by default the property name will be used as the column name. */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}