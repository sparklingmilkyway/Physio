package ch.ti.bfh.physio_app.concept;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * This class describes the attributes and functionality of an Exercise. Attention! Deleting the default constructor
 * will corrupt the junit tests.
 */


@Table(name = "EXERCISE") /* @Table is set at the class level; it allows you to define the table, catalog, and schema names for your entity mapping. If no @Table is defined the default values are used: the unqualified class name of the entity.*/
public class Exercise extends pEntityWithID {

    @Column(name = "EX_NAME")
    private String ex_name;
    @Column(name = "EX_TYPE")
    private String ex_type;
    @Column(name = "EX_NOTES")
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
