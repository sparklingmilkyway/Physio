package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class HelloWorldResource {

    @GET
    @Path("")
    public Response helloWorld() {
        return ok("Hello World").build();
    }

    @GET
    @Path("/hellow/patient/{patientId}")
    public Patient patient(@PathParam("patientId") long patientId) {
        Patient patient = new Patient();
        patient.setId(patientId);
        return patient;
    }
}
