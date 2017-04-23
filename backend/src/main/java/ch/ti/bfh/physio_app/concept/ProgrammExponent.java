package ch.ti.bfh.physio_app.concept;

import javax.persistence.*;

/**
 * Created by Vanessa on 19.03.17.
 */

/**
 * The Idea of this class is to wrap an Exercise Object with it. The intention is to be able to configure the sets and
 * reps property not in the exercise but in the ProgrammExponent class.
 */
@Entity
public class ProgrammExponent extends pEntityWithID {

    @OneToOne
    private Exercise exercise;

    @ManyToOne
    private Programm programm;

    @ManyToOne
    private Therapeut therapeut;

    @ManyToOne
    private Patient patient;

    @Column
    private int reps;

    @Column
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

    public Programm getProgramm() {
        return programm;
    }

    public void setProgramm(Programm programm) {
        this.programm = programm;
    }

    public Therapeut getTherapeut() {
        return therapeut;
    }

    public void setTherapeut(Therapeut therapeut) {
        this.therapeut = therapeut;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
