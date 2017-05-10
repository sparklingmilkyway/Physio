package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.PraxisManager;
import ch.ti.bfh.physio_app.manager.TherapeutManager;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PraxisResource {

    @Inject
    private PraxisManager praxisManager;

    @Inject
    private TherapeutManager therapeutManager;

    @GET
    @Path("/praxis/add/")
    public Response addPraxis() {
        Praxis praxis = new Praxis("Praxisname");
        praxisManager.save(praxis);
        return ok(praxis).build();
    }

    @GET
    @Path("/praxis/addTherapeuts/")
    public Response addTherapeut() {
        Praxis praxis = praxisManager.getPraxisById(1);
        Therapeut therapeut1 = new Therapeut(praxis,"Prename1", "Surname1", "pwhash1");
        Therapeut therapeut2 = new Therapeut(praxis,"Prename2", "Surname2", "pwhash2");
        therapeutManager.save(therapeut1);
        therapeutManager.save(therapeut2);
        return ok("added 2 Therapeuts").build();
    }

    @GET
    @Path("/praxis/getTherapeuts/")
    public Response getTherapeuts() {
        Praxis praxis = praxisManager.getPraxisById(1);
        List<Therapeut> therapeuts = praxisManager.getTherapeuts(praxis);
        return ok(therapeuts).build();
    }

}
