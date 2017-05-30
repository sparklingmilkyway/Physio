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
import ch.ti.bfh.physio_app.service.ImageService;

import java.io.*;
import java.util.ArrayList;
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

    @Inject
    private ImageService imageService;

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
            List<ExerciseImage> exerciseImages = getAllExerciseImagesOfExercise(exercise);
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
    private List<ExerciseNote> getAllExerciseNotesOfExercise(Exercise exercise){
        TypedQuery<ExerciseNote> query = entityManager.createQuery("SELECT e FROM ExerciseNote e WHERE e.exercise.id = :id", ExerciseNote.class);
        query.setParameter("id", exercise.getId());
        return query.getResultList();
    }

    // get all images of an exercise
    @Transactional
    private List<ExerciseImage> getAllExerciseImagesOfExercise(Exercise exercise){
        TypedQuery<ExerciseImage> query = entityManager.createQuery("SELECT e FROM ExerciseImage e WHERE e.exercise.id = :id", ExerciseImage.class);
        query.setParameter("id", exercise.getId());
        return query.getResultList();
    }



    // PICTURE STUFF

    // adding a image to an exercise
    @Transactional
    public String addImageToExercise(String imageAsString, long exerciseId){
        Exercise exercise = getExerciseById(exerciseId);

        // creating a new ExerciseImage
        ExerciseImage exerciseImage = new ExerciseImage();
        exerciseImage.setExercise(exercise);

        // setting image name to ex_EXERCISEID_IMAGEID
        exerciseImage.setImageUniqueName(exerciseId+"_"+exerciseImage.getId());

        // converting imageAsString to a file
        imageService.saveImage(imageAsString, exerciseImage.getImageUniqueName());

        save(exerciseImage);

        return "Image saved";
    }

    // get all path for images of an exercise
    @Transactional
    public List<String> getImagesOfAnExercise(long exerciseId){
        List<String> imagePaths = getExerciseImagePathList(exerciseId);
        List<String> imagesAsStrings = new ArrayList<>();
        for (String path : imagePaths)
            imagesAsStrings.add(imageService.getImageString(path));
        return imagesAsStrings;
    }

    // get all path for images of an exercise
    @Transactional
    private List<String> getExerciseImagePathList(long exerciseId){
        List<ExerciseImage> exerciseImages = getAllExerciseImagesOfExercise(getExerciseById(exerciseId));

        List<String> result = new ArrayList<>();
        String base = imageService.path + exerciseId + "_";

        for (ExerciseImage exerciseImage : exerciseImages)
            result.add(base + exerciseImage.getId() + ".jpg");
        return result;
    }

}

