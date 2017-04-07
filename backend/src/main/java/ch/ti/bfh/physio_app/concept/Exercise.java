package ch.ti.bfh.physio_app.concept;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes the attributes and functionality of an Exercise. Attention! Deleting the default constructor
 * will corrupt the junit tests.
 */

public class Exercise extends pEntityWithID {

    private String ex_name;
    private String ex_type;
    private List<String> ex_notes;

    /** TO KEEP HIBERNATE HAPPY */
    public Exercise(){

    }

    public Exercise(String name,String type){
        this.ex_name = name;
        this.ex_type = type;
        ex_notes = new ArrayList<String>();
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

    public List<String> getNotes() {
        return ex_notes;
    }

    public void setNotes(List<String> notes) {
        this.ex_notes = notes;
    }

}
