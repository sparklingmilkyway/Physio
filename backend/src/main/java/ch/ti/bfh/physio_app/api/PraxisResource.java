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


    @POST
    @Path("")
    public Response addPraxis(Praxis praxis) {
        praxisManager.save(praxis);
        return ok(praxis).build();
    }

    @GET
    @Path("")
    public Response getPraxis() {
        Praxis praxis = praxisManager.getPraxis();
        return ok(praxis).build();
    }

    @POST
    @Path("/therapeut")
    public Response addTherapeut(Therapeut therapeut) {
        therapeutManager.save(therapeut);
        return ok(therapeut).build();
    }

    @GET
    @Path("/therapeut")
    public Response getTherapeuts() {

        // used, when more than one praxis in the DB
        // List<Therapeut> therapeuts = praxisManager.getTherapeuts(praxisId);

        List<Therapeut> therapeuts = praxisManager.getTherapeuts();
        return ok(therapeuts).build();
    }

    @GET
    @Path("/therapeut/{id}")
    public Response getTherapeut(@PathParam("id") long id) {
        Therapeut therapeut = therapeutManager.getTherapeutById(id);
        return ok(therapeut).build();
    }

}
