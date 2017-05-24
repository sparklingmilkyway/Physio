package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.manager.ExerciseManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

/**
 * Created by Jonas on 24.05.2017.
 */

@Path("/exercise")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class ExerciseRessource {

    @Inject
    private ExerciseManager exerciseManager;

    @GET
    @Path("/create/name={name}/type={type}")
    public Response createNewExercise(@PathParam("name") String name,
                                      @PathParam("type") String type) {
        Exercise exercise = exerciseManager.newExercise(name,type);
        return ok(exercise).build();
    }

    @GET
    @Path("/get/")
    public List<Exercise> getExercises(){
        List<Exercise> exerciseList = exerciseManager.getAllExercises();
        return exerciseList;
    }


}
