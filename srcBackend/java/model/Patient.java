package java.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Vanessa on 19.03.17.
 */
public class Patient extends pEntityWithID{

    private String surname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "id")
    private Therapeut therapeut;
    private Programm programm;

    public Patient(String surname, String lastname, Therapeut therapeut){
        this.surname = surname;
        this.lastname = lastname;
        this.therapeut = therapeut;
        this.programm = new Programm("Placeholder");
    }

    public String getTherapeut(String t){
        return this.therapeut.getName();
    }

    public void addProgramm(Programm programm){
        this.programm = programm;
    }

    /*
    public void addExercise(Exercise exercise){
        if(exerciseList.contains(exercise)){
            return;
        }
        exerciseList.add(exercise);
    }

    public void removeExercise(Exercise exercise){
        if(exerciseList.contains(exercise)){
            exerciseList.remove(exercise);
        }
        return;
    }

    public List getExercises(){
        return this.exerciseList;
    }
    */
    public String getName(){
        return (this.surname+this.lastname);
    }
}
