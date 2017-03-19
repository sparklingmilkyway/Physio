package java.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private String name;
    private String type;
    private List<String> notes;

    public Exercise(String name,String type){
        this.name = name;
        this.type = type;
        notes = new ArrayList<String>();
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public Exercise getExercise(){
        return this;
    }

    public void AddNote(String note){
        notes.add(note);
    }

    public boolean RemoveNote(String note){
        for(String n : this.notes){
            if(n.equals(note)){
                notes.remove(n);
                return true;
            }
        }
        return false;
    }
}
