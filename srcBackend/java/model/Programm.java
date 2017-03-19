package java.model;

import java.util.*;

public class Programm extends pEntityWithID{

    private List<ProgrammExponent> exerciseList;
    private String name;


    public Programm(String name){
        this.name = name;
        exerciseList = new ArrayList<ProgrammExponent>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ProgrammExponent addExercise(Exercise exercise, int sets, int reps){
        ProgrammExponent proExp = new  ProgrammExponent(exercise, sets, reps);
        this.exerciseList.add(proExp);
        return proExp;
    }

    public boolean removeProgrammExponentByExercise(Exercise exercise){
        for (int i = 0; i < exerciseList.size(); i++) {
            ProgrammExponent progExp = new ProgrammExponent();
            if (exerciseList.get(i).getExercise()==exercise) {
                progExp = exerciseList.get(i);
            }
        }

        if(this.exerciseList.contains(progExp)){
            this.exerciseList.remove(progExp);
            return true;
        }
        return false;
    }

    public boolean removeProgrammExponent(ProgrammExponent exercise){
        if(this.exerciseList.contains(exercise)){
            this.exerciseList.remove(exercise);
            return true;
        }
        return false;
    }

    public List getExercises(){
        return this.exerciseList;
    }


}