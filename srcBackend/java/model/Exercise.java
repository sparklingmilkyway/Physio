package java.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise extends pEntityWithID {

    private String name;
    private String type;
    private List<String> notes;

    public Exercise(String name,String type){
        this.name = name;
        this.type = type;
        notes = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
