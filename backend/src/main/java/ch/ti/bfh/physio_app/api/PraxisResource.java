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

    @Inject
    private PatientManager patientManager;


    @GET
    @Path("/add")
    public Response addPraxis() {
        Praxis praxis = new Praxis("Praxisname");
        praxisManager.save(praxis);
        return ok(praxis).build();
    }


    @GET
    @Path("/addTherapeut")
    public Response addTherapeut() {
        long id = 1;
        Praxis praxis = praxisManager.getPraxisById(id);
        Therapeut therapeut = new Therapeut(praxis,"Prename1", "Surname1", "email@mail", "pwhash1");
        therapeutManager.save(therapeut);
        return ok(therapeut).build();
    }

    @GET
    @Path("/getTherapeuts")
    public Response getTherapeuts() {
        long id = 1;
        Praxis praxis = praxisManager.getPraxisById(id);
        List<Therapeut> therapeuts = praxisManager.getTherapeuts(praxis);
        return ok(therapeuts).build();
    }

}
