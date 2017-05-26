package ch.ti.bfh.physio_app.manager;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import ch.ti.bfh.physio_app.concept.*;
import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.ExerciseNote;
import ch.ti.bfh.physio_app.concept.Patient;

import java.io.*;
import java.util.List;

/**
 * All Operations including Database queries for the Exercise class are created in here. We use an EntityManger for all
 * Database modifications and queries.
 * @Transactional: Used to make sure that the Methods are atomic.
 * @ApplicationScoped: Makes sure that the instance of ExerciseManager will be created excactly once during runtime.
 */
@ApplicationScoped
public class ExerciseManager {

    /**
     * The EntityManager will be created using the information
     in the file META-INF/persistence.xml. To use it at runtime, we simply need to request it to be injected into one of out components. We do this via
     @PersistenceContext
     */
    @PersistenceContext(unitName = "physio_app")
    private EntityManager entityManager;

    @Transactional
    public void save(Exercise ex) {
        entityManager.persist(ex);
    }

    @Transactional
    public Exercise getExerciseById(long id){
            return entityManager.find(Exercise.class, id);
    }

    @Transactional
    public Exercise addNote(String note, Exercise exercise){
        exercise.getNotes().add(new ExerciseNote(note, exercise));
        save(exercise);
        return getExerciseById(exercise.getId());
    }

    @Transactional
    public Exercise addNote(ExerciseNote note, Exercise exercise){
        exercise.getNotes().add(note);
        save(exercise);
        return getExerciseById(exercise.getId());
    }

    @Transactional
    public boolean removeNote(ExerciseNote note, Exercise exercise){
        if (exercise.getNotes().contains(note)) {
            exercise.getNotes().remove(note);
            save(exercise);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean removeExercise(long id){
        List<Exercise> exercises = getAllExercises();
        for(Exercise e : exercises){
            if(e.getId() == id){
                entityManager.remove(e);
                return true;
            }
        }
        return false;
    }

    public ExerciseNote getNote(Exercise exercise, ExerciseNote exerciseNote){
        List<ExerciseNote> exerciseList = exercise.getNotes();
        if(exerciseList.contains(exerciseNote)){
            return exerciseNote;
        }
        else{
            ExerciseNote exn = new ExerciseNote();
            return exn;
        }
    }

    @Transactional
    public Exercise newExercise(String name,String type) {
        Exercise ex = new Exercise();
        ex.setName(name);
        ex.setType(type);
        long ex_id = ex.getId();
        save(ex);
        return ex;
    }

    @Transactional
    public boolean removeExercise(Exercise exercise){
         if (entityManager.contains(exercise)) {
            entityManager.remove(exercise);
            return true;
        }
        else return false;
    }

    @Transactional
    public Exercise updateExercise(long exerciseID, String name, String type, Therapeut therapeut){
        Exercise exercise = getExerciseById(exerciseID);
        exercise.setName(name);
        exercise.setType(type);
        exercise.setTherapeut(therapeut);
        save(exercise);
        return exercise;
    }
    @Transactional
    public List<Exercise> getAllExercises(){
        TypedQuery<Exercise> query = entityManager.createQuery("SELECT e FROM Exercise e", Exercise.class);
        return query.getResultList();
    }



    // PICTURE STUFF

    @Transactional
    public List<Picture> getAllPicturesOfExercise(Exercise exercise){
        long exerciseId = exercise.getId();
        TypedQuery<Picture> query = entityManager.createQuery("SELECT p FROM Picture p Where p.exercise.id = :id", Picture.class);
        query.setParameter("id", exerciseId);
        return query.getResultList();
    }


    @Transactional
    public void save(Picture picture) {
        entityManager.persist(picture);
    }


    @Transactional
    public Picture getPictureById(long id){
        TypedQuery<Picture> query = entityManager.createQuery("SELECT p FROM Picture p where p.id = :id", Picture.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    public File getPictureFileById(long id){
        //Picture picture = getPictureById(id);
        File pictureFile = new File("c:\\data\\exImages\\"+id+".jpg");
        return pictureFile;
    }

    @Transactional
    public String addPictureFileToExercise(Exercise exercise, InputStream uploadedInputStream){

        // Create Picture in DB and get unique ID
        Picture picture = new Picture(exercise);
        long id = picture.getId();
        save(picture);

        //Server
        //String uploadedFileLocation = "/data/exImages/" + fileDetail.getFileName();
        //local Vanessa
        String uploadedFileLocation = "/Users/Vanessa/Desktop/" + id + ".jpg";

        System.out.println(uploadedFileLocation);

        // save it
        File  objFile=new File(uploadedFileLocation);
        if(objFile.exists())
            objFile.delete();

        saveToFile(uploadedInputStream, uploadedFileLocation);

        String output = "File uploaded via Jersey based RESTFul Webservice to: " + uploadedFileLocation;

        return output;
    }

    private void saveToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

        try {
            OutputStream outputStream = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            outputStream = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

