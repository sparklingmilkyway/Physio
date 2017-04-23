package ch.ti.bfh.physio_app.concept;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class describes the attributes and functionality of an Exercise. Attention! Deleting the default constructor
 * will corrupt the junit tests.
 */
@Entity
public class Exercise extends pEntityWithID {

    @Column
    private String ex_name;

    @Column
    private String ex_type;

    @OneToMany
    private List<ExerciseNote> ex_notes = new ArrayList<>();

    @ManyToOne
    private Therapeut therapeut;

    /** TO KEEP HIBERNATE HAPPY */
    public Exercise(){ }

    public Exercise(String name, String type, Therapeut therapeut){
        this.ex_name = name;
        this.ex_type = type;
        this.therapeut = therapeut;
    }

    public Exercise(String name, String type, ArrayList<ExerciseNote> notes, Therapeut therapeut){
        this.ex_name = name;
        this.ex_type = type;
        this.ex_notes = notes;
    }

    public String getName() {
        return ex_name;
    }

    public void setName(String name) {
        this.ex_name = name;
    }

    public String getType() {
        return ex_type;
    }

    public void setType(String type) {
        this.ex_type = type;
    }

    public List<ExerciseNote> getNotes() {
        return ex_notes;
    }

    public void setNotes(List<ExerciseNote> notes) {
        this.ex_notes = notes;
    }

}
