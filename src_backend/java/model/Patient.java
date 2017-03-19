package java.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vanessa on 19.03.17.
 */
public class Patient {

    private String surname;
    private String lastname;
    private int id;
    private Therapeut therapeut;
    //private List<Exercise> exerciseList;
    private Programm programm;

    public Patient(String surname, String lastname,int id, Therapeut therapeut){
        this.surname = surname;
        this.lastname = lastname;
        this.therapeut = therapeut;
        this.programm = new Programm("Placeholder");
        //exerciseList = new ArrayList<Exercise>();
        this.id = id;
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
