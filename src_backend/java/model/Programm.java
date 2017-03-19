package java.model;

import java.util.ArrayList;
import java.util.List;

public class Programm {
    private List<Exercise> exerciseList;
    private String name;

    public Programm(String name){
        this.name = name;
        exerciseList = new ArrayList<Exercise>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addExercise(Exercise exercise){
        this.exerciseList.add(exercise);
    }

    public boolean removeExercise(Exercise exercise){
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