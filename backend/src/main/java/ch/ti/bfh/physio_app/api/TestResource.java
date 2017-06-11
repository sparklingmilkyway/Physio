package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.LoginManager;
import ch.ti.bfh.physio_app.manager.PraxisManager;
import ch.ti.bfh.physio_app.manager.TherapeutManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("/test")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class TestResource {

    @Inject
    private TherapeutManager therapeutManager;

    @Inject
    private PraxisManager praxisManager;


    // set all
    @GET
    @Path("")
    public Response doAllSettings() {
        therapeutManager.save(new Therapeut("Jonas","Nydegger","jonas@nydegger", LoginManager.doHash("helloworld")));
        praxisManager.save(new Praxis("Testpraxis"));
        return ok("OK").build();
    }
}
