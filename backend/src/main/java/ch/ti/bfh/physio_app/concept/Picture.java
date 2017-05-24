package ch.ti.bfh.physio_app.concept;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Picture extends pEntityWithID {

    @ManyToOne
    private Exercise exercise;

    /** TO KEEP HIBERNATE HAPPY */
    public Picture(){ }

    public Picture(Exercise exercise){
        this.exercise = exercise;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
