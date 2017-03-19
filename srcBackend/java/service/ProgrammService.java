package java.service;

import java.concept.Exercise;
import java.concept.ProgrammExponent;

public class ProgrammService {

    private EntityManager entityManager = new EntityManager();

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
}

