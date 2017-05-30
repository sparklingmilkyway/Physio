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
    public void save(Exercise exercise) {
        entityManager.persist(exercise);
    }

    @Transactional
    public void save(ExerciseNote exerciseNote) {
        entityManager.persist(exerciseNote);
    }

    @Transactional
    public void save(ExerciseImage exerciseImage) {
        entityManager.persist(exerciseImage);
    }


    @Transactional
    public Exercise getExerciseById(long id){
            return entityManager.find(Exercise.class, id);
    }


    // add a note
    @Transactional
    public ExerciseNote addNote(String note, Exercise exercise){
        ExerciseNote exerciseNote = new ExerciseNote(note, exercise);
        save(exerciseNote);
        return exerciseNote;
    }

    // add an image
    @Transactional
    public ExerciseImage addImage(String imageUniqueName, Exercise exercise){
        ExerciseImage exerciseImage = new ExerciseImage(imageUniqueName, exercise);
        save(exerciseImage);
        return exerciseImage;
    }

    // remove a note
    @Transactional
    public boolean removeNote(ExerciseNote note){
        if (entityManager.contains(note)) {
            entityManager.remove(note);
            return true;
        }
        return false;
    }

    // remove an image
    @Transactional
    public boolean removeImage(ExerciseImage image){
        if (entityManager.contains(image)) {
            entityManager.remove(image);
            return true;
        }
        return false;
    }

    // remove an exercise
    @Transactional
    public boolean removeExercise(Exercise exercise){
        long exerciseId = exercise.getId();
        if (entityManager.contains(exercise)) {
            List<ExerciseNote> exerciseNotes = getAllExerciseNotesOfExercise(exercise);
            for (ExerciseNote exerciseNote: exerciseNotes) {
                removeNote(exerciseNote);
            }
            List<ExerciseImage> exerciseImages = getAllImagesOfExercise(exercise);
            for (ExerciseImage exerciseImage: exerciseImages) {
                removeImage(exerciseImage);
            }

            entityManager.remove(exercise);
            return true;
        }
        return false;
    }

    // update an exercise
    @Transactional
    public Exercise updateExercise(Exercise exerciseToUpdate, Exercise exercise){
        exerciseToUpdate.setName(exercise.getName());
        exerciseToUpdate.setTherapeut(exercise.getTherapeut());
        exerciseToUpdate.setType(exercise.getType());
        save(exerciseToUpdate);
        return exerciseToUpdate;
    }

    // get all exercises
    @Transactional
    public List<Exercise> getAllExercises(){
        TypedQuery<Exercise> query = entityManager.createQuery("SELECT e FROM Exercise e", Exercise.class);
        return query.getResultList();
    }

    // get all notes of an exercise
    @Transactional
    public List<ExerciseNote> getAllExerciseNotesOfExercise(Exercise exercise){
        TypedQuery<ExerciseNote> query = entityManager.createQuery("SELECT e FROM ExerciseNote e WHERE e.exercise.id = :id", ExerciseNote.class);
        query.setParameter("id", exercise.getId());
        return query.getResultList();
    }

    // get all images of an exercise
    @Transactional
    public List<ExerciseImage> getAllImagesOfExercise(Exercise exercise){
        TypedQuery<ExerciseImage> query = entityManager.createQuery("SELECT e FROM ExerciseImage e WHERE e.exercise.id = :id", ExerciseImage.class);
        query.setParameter("id", exercise.getId());
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

