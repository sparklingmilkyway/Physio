package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Exercise;
import ch.ti.bfh.physio_app.concept.Programm;
import ch.ti.bfh.physio_app.concept.ProgrammComponent;
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

    // creating a new programm
    @POST
    @Path("")
    public Response createProgramm(Programm programm) {
        programmManager.save(programm);
        return ok(programm).build();
    }

    // updating a programm
    @POST
    @Path("/update")
    public Response updateProgramm(Programm programm) {
        programmManager.save(programm);
        Programm updatedProgramm = programmManager.getProgrammById(programm.getId());
        return ok(updatedProgramm).build();
    }

    // add a component to programm
    @POST
    @Path("/{id}/component")
    public Response addComponentToProg(@PathParam("id") long programmId, ProgrammComponent programmComponent) {
        Programm programm = programmManager.addProgrammComponentToProgramm(programmManager.getProgrammById(programmId), programmComponent);
        return ok(programm).build();
    }

    // get components of programm
    @GET
    @Path("/{id}/component")
    public List<ProgrammComponent> getComponentsOfProgramm(@PathParam("id") long programmId) {
        List<ProgrammComponent> components = programmManager.getProgrammComponentsByProgramm(programmId);
        return components;
    }

    // create component
    @POST
    @Path("/component")
    public Response createComponent(ProgrammComponent programmComponent){
        programmManager.save(programmComponent);
        return ok(programmComponent).build();

    }

    // get all programms
    @GET
    @Path("")
    public List<Programm> getProgramms() {
        List<Programm> programms = programmManager.getAllProgramms();
        return programms;
    }

    // get programm by id
    @GET
    @Path("/{id}")
    public Programm getProgramm(@PathParam("id") long id){
            Programm programm = programmManager.getProgrammById(id);
            return programm;
    }

    // get component by id
    @GET
    @Path("/component/{id}")
    public ProgrammComponent getProgrammcomponent(@PathParam("id") long id){
        ProgrammComponent programmComponent = programmManager.getProgrammComponentById(id);
        return programmComponent;
    }








}
