package java.service;

import java.model.Programm;

/**
 * Created by Vanessa on 19.03.17.
 */
public class PatientService {


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
