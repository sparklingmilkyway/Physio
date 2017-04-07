package ch.ti.bfh.physio_app.concept;

import java.util.*;

/**
 * This class describes the attributes and functionality of a Programm object. A Programm does not contain directly
 * A List with Exercises but a ProgrammExponent List. The Objects contains one Exercise Object each. Attention! Deleting
 * the default constructor will corrupt the Junit tests.
 */

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