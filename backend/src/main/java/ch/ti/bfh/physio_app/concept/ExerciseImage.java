package ch.ti.bfh.physio_app.concept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ExerciseImage extends pEntityWithID {

    @Column
    private String imageUniqueName;

    @ManyToOne
    private Exercise exercise;

    /** TO KEEP HIBERNATE HAPPY */
    public ExerciseImage(){

    }

    public ExerciseImage(String note, Exercise exercise){
        this.imageUniqueName = note;
        this.exercise = exercise;
    }

    public String getImageUniqueName() {
        return imageUniqueName;
    }

    public void setImageUniqueName(String imageUniqueName) {
        this.imageUniqueName = imageUniqueName;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
