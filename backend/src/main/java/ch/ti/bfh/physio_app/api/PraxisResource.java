package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.manager.PraxisManager;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PraxisResource {

    @GET
    @Path("/praxis")
    public Response praxis() {
        return ok("Hello World").build();
    }

    @GET
    @Path("/praxis/{praxisId}")
    public Response praxis(@PathParam("praxisId") long praxisId) {
        Praxis praxis = new Praxis("Praxisname");
        praxis.setId(praxisId);
        return ok(praxis).build();
    }

    @GET
    @Path("/praxisfromdb/{praxisId}")
    public Response praxisfromdb(@PathParam("praxisId") long praxisId) {
        Praxis praxis = new Praxis("Praxisname");
        praxis.setId(praxisId);
        return ok(praxis).build();
    }


    @GET
    @Path("/praxis/add/")
    public Response addPraxis() {
        PraxisManager pm = new PraxisManager();
        Praxis praxis = new Praxis("Praxisname");
        //pm.save(praxis);
        return ok(praxis).build();
    }

}
