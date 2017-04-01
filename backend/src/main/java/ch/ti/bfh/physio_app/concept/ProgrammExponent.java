package concept;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Vanessa on 19.03.17.
 */
public class ProgrammExponent extends pEntityWithID {

    @OneToOne
    @JoinColumn(name = "id")
    private Exercise exercise;
    private int reps;
    private int sets;

    /** TO KEEP HIBERNATE HAPPY */
    public ProgrammExponent(){

    }

    public ProgrammExponent(Exercise exercise, int sets, int reps){
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

}
