package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.PatientManager;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;


/**
 * Created by Jonas on 14.05.2017.
 */

@Path("")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PatientRessource{

    @Inject
    private PatientManager patientManager;

    @GET
    @Path("/patient/add/")
    public Response addPatient(){
        Therapeut t = new Therapeut();
        Patient p = new Patient("Jonas","Nydegger",t);
        patientManager.save(p);
        return ok(p).build();
    }
}
