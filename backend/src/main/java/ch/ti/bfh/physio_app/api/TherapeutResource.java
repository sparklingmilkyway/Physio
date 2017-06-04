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

@Path("/therapeut")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class TherapeutResource {

    @Inject
    private TherapeutManager therapeutManager;


    // creating a new therapeut
    @POST
    @Path("")
    public Response addTherapeut(Therapeut therapeut) {
        therapeutManager.save(therapeut);
        return ok(therapeut).build();
    }

    // update therapeut
    @PUT
    @Path("/update")
    public Response update(Therapeut therapeut) {
        therapeutManager.save(therapeut);
        Therapeut updatedTherapeut = therapeutManager.getTherapeutById(therapeut.getId());
        return ok(updatedTherapeut).build();
    }

    // get all therapeuts
    @GET
    @Path("")
    public Response getTherapeuts() {
        List<Therapeut> therapeuts = therapeutManager.getTherapeuts();
        return ok(therapeuts).build();
    }

    // get therapeut by id
    @GET
    @Path("/{id}")
    public Response getTherapeut(@PathParam("id") long id) {
        Therapeut therapeut = therapeutManager.getTherapeutById(id);
        return ok(therapeut).build();
    }


    // get therapeut by id
    @DELETE
    @Path("/{id}")
    public Response delet(@PathParam("id") long id) {
        therapeutManager.delete(id);
        return ok().build();
    }


}
