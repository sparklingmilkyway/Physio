package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;

import javax.ws.rs.*; import javax.ws.rs.core.Response;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UserResource {

    /** Praxis **/
    @GET
    @Path("/praxis/{praxisId}")
    public Response praxis(@PathParam("praxisId") long praxisId) {
        //get praxis from service
        Praxis praxis = new Praxis();
        praxis.setId(praxisId);
        return ok("Praxis site").build();
    }

    @POST
    @Path("/praxis/{praxisId}")
    public Response praxis(@PathParam("praxisId") long praxisId, Praxis praxis) {
        // give praxisId + praxis to service
        return ok("Success/Faild").build();
    }

    /** Patient **/
    @GET
    @Path("/patient")
    public Response patient() {
        // get a set of patients from service
        return ok("Patient site").build();
    }

    @GET
    @Path("/patient/{patientId}")
    public Response patient(@PathParam("patientId") long patientId) {
        //get patient from service
        Patient patient = new Patient();
        patient.setId(patientId);
        return ok(patient).build();
    }

    @GET
    @Path("/patient/{patientId}/programms")
    public Response patientprogramms(@PathParam("patientId") long patientId) {
        //get the programms of a patient form service
        return ok("get the programms of a patient form service").build();
    }

    @GET
    @Path("/patient/{patientId}/exercises")
    public Response patientexercises(@PathParam("patientId") long patientId) {
        //get the exercises of a patient form service
        return ok("get the exercises of a patient form service").build();
    }

    @POST
    @Path("/patient/{patientId}")
    public Response patient(@PathParam("patientId") long patientId, Patient patient) {
        // give patient + patientId to service
        return ok("Success/Faild").build();
    }

    /** Therapeut **/
    @GET
    @Path("/therapeut")
    public Response therapeut() {
        // get a set of therapeut from service
        return ok("Therapeut site").build();
    }

    @GET
    @Path("/therapeut/{therapeutId}")
    public Response therapeut(@PathParam("therapeutId") long patientId) {
        //get therapeuts from service
        Therapeut therapeut = new Therapeut();
        therapeut.setId(patientId);
        return ok(therapeut).build();
    }

    @GET
    @Path("/therapeut/{therapeutId}/programms")
    public Response therapeutsProgramm(@PathParam("therapeutId") long patientId) {
        //get the programms of a therapeu form service
        return ok("get the programms of a therapeut form service").build();
    }

    @GET
    @Path("/therapeut/{therapeutId}/exercises")
    public Response therapeutExercises(@PathParam("therapeutId") long patientId) {
        //get the exercises of a therapeu form service
        return ok("get the exercises of a therapeut form service").build();
    }


    @GET
    @Path("/therapeut/{therapeutId}/patients")
    public Response therapeutPatients(@PathParam("therapeutId") long patientId) {
        //get the exercises of a therapeut form service
        return ok("get the patients of a therapeut form service").build();
    }

    @POST
    @Path("/therapeut/{therapeutId}")
    public Response therapeut(@PathParam("therapeutId") long therapeutId, Therapeut therapeut) {
        // give therapeutId + therapeut to service
        return ok("Success/Faild").build();
    }

}
