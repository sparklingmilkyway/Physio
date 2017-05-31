package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.manager.ExerciseManager;
import ch.ti.bfh.physio_app.manager.ProgrammManager;

import javax.inject.Inject;
import javax.ws.rs.*; import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

@Path("/programm")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class ProgrammResource {

    @Inject
    private ProgrammManager programmManager;

    @GET
    @Path("")
    public List<Programm> getAllProgramms(){
        return programmManager.getAllProgramms();
    }

    @GET
    @Path("{id}")
    public Programm getProgrammByID(@PathParam("id") long programmId) {
        return programmManager.getProgrammById(programmId);
    }


}
