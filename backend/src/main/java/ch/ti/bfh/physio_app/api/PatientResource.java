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

        import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
        import static javax.ws.rs.core.Response.ok;

@Path("/patient")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PatientResource {

    @Inject
    private PraxisManager praxisManager;

    @Inject
    private TherapeutManager therapeutManager;

    @Inject
    private PatientManager patientManager;

    @GET
    @Path("/add")
    public Response addPatient() {
        long id = 1;
        Praxis praxis = praxisManager.getPraxisById(id);
        Therapeut therapeut = therapeutManager.getTherapeutById(id);
        Patient patient = new Patient("Jonas","Nydegger", "jonas@mail.ch", "pwhs", therapeut);
        patientManager.save(patient);
        return ok(patient).build();

    }



}
