package java.service;

/**
 * Created by Vanessa on 19.03.17.
 */
public class ExerciseService {

    private EntityManager entityManager = new EntityManager();

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
