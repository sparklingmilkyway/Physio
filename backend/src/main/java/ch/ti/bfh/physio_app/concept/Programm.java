package concept;

import java.util.*;

public class Programm extends pEntityWithID{

    private List<ProgrammExponent> exerciseList;
    private String name;

    /** TO KEEP HIBERNATE HAPPY */
    public Programm(){

    }

    public Programm(String name){
        this.name = name;
        exerciseList = new ArrayList<ProgrammExponent>();
    }

    public List<ProgrammExponent> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<ProgrammExponent> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}