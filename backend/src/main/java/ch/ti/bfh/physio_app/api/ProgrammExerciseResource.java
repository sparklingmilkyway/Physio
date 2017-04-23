package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.manager.ExerciseManager;

import javax.inject.Inject;
import javax.ws.rs.*; import javax.ws.rs.core.Response;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

@Path("")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class ProgrammExerciseResource {

    @Inject
    private ExerciseManager exerciseManager;

    /** Programm **/
    @GET
    @Path("/programm")
    public Response programm() {
        // get a set of programm from service
        return ok("Programm site").build();
    }

    @GET
    @Path("/programm/{programmId}")
    public Response patient(@PathParam("programmId") long programmId) {
        //get programm from service
        Programm programm = new Programm();
        programm.setId(programmId);
        return ok(programm).build();
    }


    @POST
    @Path("/programm/{programmId}")
    public Response patient(@PathParam("programmId") long programmId, Programm programm) {
        // give patient + patientId to service
        return ok("Success/Faild").build();
    }

    /** Exercise **/

    @GET
    @Path("/exercise")
    public Response exercise() {

        return ok("Exercise site").build();
    }

    @GET
    @Path("/exercise/{exerciseId}")
    public Response exercise(@PathParam("exerciseId") long exerciseId) {
        //get exercise from service
        Exercise exercise = exerciseManager.getExerciseById(exerciseId);
        return ok(exercise).build();
    }

    @POST
    @Path("/{exerciseId}")
    public Response exercise(@PathParam("exerciseId") long exerciseId, Exercise exercise) {
        // give exercise + exerciseId to service
        return ok("Success/Faild").build();
    }

    /** ProgrammExponent **/

    @GET
    @Path("/programm/{programmId}/exercises/{programmExponentId}")
    public Response patient(@PathParam("programmId") long programmId, @PathParam("programmExponentId") long programmExponentId) {
        //get programm exponent from service
        return ok("get programm exponent from service").build();
    }

}
