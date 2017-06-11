package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.PatientManager;
import ch.ti.bfh.physio_app.manager.PraxisManager;
import ch.ti.bfh.physio_app.manager.TherapeutManager;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("/praxis")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PraxisResource {

    @Inject
    private PraxisManager praxisManager;

    @Inject
    private TherapeutManager therapeutManager;


    // creating a new praxis
    @POST
    @Path("")
    public Response addPraxis(Praxis praxis) {
        praxisManager.save(praxis);
        return ok(praxis).build();
    }

    // get a new praxis
    @GET
    @Path("")
    public Praxis getPraxis() {
        Praxis praxis = praxisManager.getPraxis();
        return praxis;
    }

    // creating a new therapeut
    @POST
    @Path("/therapeut")
    public Response addTherapeut(Therapeut therapeut) {
        therapeutManager.save(therapeut);
        return ok(therapeut).build();
    }

    // get all therapeuts
    @GET
    @Path("/therapeut")
    public Response getTherapeuts() {

        // used, when more than one praxis in the DB
        // List<Therapeut> therapeuts = praxisManager.getTherapeuts(praxisId);

        List<Therapeut> therapeuts = praxisManager.getTherapeuts();
        return ok(therapeuts).build();
    }

    // get therapeut by id
    @GET
    @Path("/therapeut/{id}")
    public Response getTherapeut(@PathParam("id") long id) {
        Therapeut therapeut = therapeutManager.getTherapeutById(id);
        return ok(therapeut).build();
    }

    // update therapeut
    @POST
    @Path("/therapeut/update")
    public Response getTherapeut(Therapeut therapeut) {
        therapeutManager.save(therapeut);
        Therapeut updatedTherapeut = therapeutManager.getTherapeutById(therapeut.getId());
        return ok(updatedTherapeut).build();
    }

}
