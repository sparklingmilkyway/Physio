package ch.ti.bfh.physio_app.api;


import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.manager.*;
import ch.ti.bfh.physio_app.manager.ImageService;
import org.apache.commons.io.IOUtils;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;
import java.util.List;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;


/**
* This is the REST ressource for all exercise calls from the angular frontend which go to our jboss server inlcuding
 * all queries for our images
*
 */
@Path("/exercise")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class ExerciseResource {

    @Inject
    private PraxisManager praxisManager;

    @Inject
    private TherapeutManager therapeutManager;

    @Inject
    private PatientManager patientManager;

    @Inject
    private ExerciseManager exerciseManager;



    // creating a new exercise
    @POST
    @Path("")
    public Response createExercise(Exercise exercise) {
        exerciseManager.save(exercise);
        return ok(exercise).build();
    }

    // updating a exercise
    @POST
    @Path("/update")
    public Response updateExercise(Exercise exercise) {
        Exercise exerciseToUpdate = exerciseManager.getExerciseById(exercise.getId());
        exerciseManager.updateExercise(exerciseToUpdate, exercise);
        return ok(exercise).build();
    }


    // get exercise by id
    @GET
    @Path("/{id}")
    public Response getExercise(@PathParam("id") long id){
        try {
            Exercise exercise = exerciseManager.getExerciseById(id);
            return ok(exercise).build();
        } catch (Exception ex){
            Exercise exercise = new Exercise();
            exercise.setName("Kein Exercise mit dieser ID gefunden...");
            return ok(exercise).build();
        }
    }


    // get all exercises
    @GET
    @Path("")
    public List<Exercise> getExercises(){
        List<Exercise> exerciseList = exerciseManager.getAllExercises();
        return exerciseList;
    }

    // remove exercise
    @GET
    @Path("/remove/{id}")
    public boolean removePatient(@PathParam("id") long id){
        return exerciseManager.removeExercise(exerciseManager.getExerciseById(id));
    }

    // get image for exercise AT MOMENT ONLY ONE
    @GET
    @Path("/{exerciseId}/image")
    public Response getImage(@PathParam("exerciseId") long exerciseId) {

        final File file =  exerciseManager.getImageFileOfExercise(exerciseId);

        final StreamingOutput stream = rawOutputStream -> {
            try (final InputStream inputStream = new FileInputStream(file)) {
                final OutputStream outputStream = new BufferedOutputStream(rawOutputStream);
                IOUtils.copyLarge(inputStream, outputStream);
                outputStream.flush();
            }
        };
        return ok(stream)
                .type("image/jpeg")
                .build();
    }

    // nice to know: http request is always a stream
    // upload image for exercise
    @POST
    @Consumes(MediaType.WILDCARD)
    @Path("/{id}/image")
    public Response uploadImage(@PathParam("id") int exerciseId, InputStream inputStream) throws IOException {
        String uniqueExcerciseImageName = exerciseManager.addImageToExercise(exerciseId);
        final File outputFile = new File(ImageService.path + uniqueExcerciseImageName + ".jpg");
        try (OutputStream outputStream =  new BufferedOutputStream(new FileOutputStream(outputFile))) {
            IOUtils.copy(inputStream, outputStream);
        }

        return ok().build();
    }

}
