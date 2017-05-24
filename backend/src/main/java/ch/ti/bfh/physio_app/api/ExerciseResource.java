package ch.ti.bfh.physio_app.api;


import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.*;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;
import java.util.List;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

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
    private LoginManager loginManager;

    @Inject
    private ExerciseManager exerciseManager;

    // CREATING A NEW EXERCISE
    @GET
    @Path("/create/name={exerciseName}/type={exerciseType}/therapeut={theraId}")
    public Response createExercise( @PathParam("exerciseName") String exerciseName,
                                      @PathParam("exerciseType") String exerciseType,
                                      @PathParam("theraId") long therapeutID) {
        Therapeut therapeut = therapeutManager.getTherapeutById(therapeutID);
        Exercise exercise = new Exercise(exerciseName, exerciseType, therapeut);
        exerciseManager.save(exercise);
        return ok(exercise).build();
    }

    // UPDATING A EXERCISE
    @GET
    @Path("/update/id={exerciseID}/name={exerciseName}/type={exerciseType}/therapeut={theraId}")
    public Response updateExercise(@PathParam("exerciseID") long exerciseID,
                                   @PathParam("exerciseName") String exerciseName,
                                     @PathParam("exerciseType") String exerciseType,
                                     @PathParam("theraId") long therapeutID) {
        Therapeut therapeut = therapeutManager.getTherapeutById(therapeutID);
        Exercise exercise = exerciseManager.updateExercise(exerciseID, exerciseName, exerciseType, therapeut);
        return ok(exercise).build();
    }

    @GET
    @Path("/get/id={id}")
    public Response getExercise(@PathParam("id") long id){
        Exercise exercise = exerciseManager.getExerciseById(id);
        return ok(exercise).build();
    }


    @GET
    @Path("/get")
    public List<Exercise> getExercises(){
        List<Exercise> exerciseList = exerciseManager.getAllExercises();
        return exerciseList;
    }


    @Path("/image/{id}")
    public Response getImage(@PathParam("id") long id) {
        final File file =  exerciseManager.getPictureFileById(id);
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


    @POST
    @Path("/fileupload/exercise={id}")  //Your Path or URL to call this service
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @DefaultValue("true") @FormDataParam("enabled") boolean enabled,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail,
            @PathParam("id") long exerciseID) {

        String result = exerciseManager.addPictureFileToExercise(exerciseManager.getExerciseById(exerciseID), uploadedInputStream);

        return Response.status(200).entity(result).build();

    }

}
