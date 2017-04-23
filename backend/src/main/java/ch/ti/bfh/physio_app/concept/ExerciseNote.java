package ch.ti.bfh.physio_app.concept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * This class describes the attributes and functionality of an Exercise. Attention! Deleting the default constructor
 * will corrupt the junit tests.
 */
@Entity
public class ExerciseNote extends pEntityWithID {

    @Column
    private String exerciseNote;

    @ManyToOne
    private Exercise exercise;

    /** TO KEEP HIBERNATE HAPPY */
    public ExerciseNote(){

    }

    public ExerciseNote(String note, Exercise exercise){
        this.exerciseNote = note;
        this.exercise = exercise;
    }

    public String getExerciseNote() {
        return exerciseNote;
    }

    public void setExerciseNote(String exerciseNote) {
        this.exerciseNote = exerciseNote;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
