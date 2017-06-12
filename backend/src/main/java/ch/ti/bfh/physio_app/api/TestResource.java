package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.*;
import ch.ti.bfh.physio_app.manager.*;

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

    @Inject
    private ExerciseManager exerciseManager;

    @Inject
    private ProgrammManager programmManager;

    @Inject
    private PatientManager patientManager;


    // set all
    @GET
    @Path("")
    public Response doAllSettings() {
        therapeutManager.save(new Therapeut("Jonas","Nydegger","jonas@nydegger", LoginManager.doHash("helloworld")));
        praxisManager.save(new Praxis("Testpraxis"));
        return ok("OK").build();
    }

    // set all
    @GET
    @Path("/exercise")
    public Response doExerciseSEttings() {

       // exerciseManager.save(new Exercise("Exercisename", "Exercisetype", therapeutManager.getTherapeutByEmail("jonas@nydegger")));
        exerciseManager.save(new Exercise("Exercisename2", "Exercisetype", therapeutManager.getTherapeutByEmail("jonas@nydegger")));
       //  exerciseManager.save(new Exercise("Exercisename3", "Exercisetype", therapeutManager.getTherapeutByEmail("jonas@nydegger")));

        return ok("OK - Exercise").build();
    }

    // set all
    @GET
    @Path("/patient")
    public Response doPatientsSettings() {

        patientManager.save(new Patient("Hans", "Müller", "hans@müller",therapeutManager.getTherapeutByEmail("jonas@nydegger")));
        patientManager.save(new Patient("Vera", "Zulauf", "vera@mail",therapeutManager.getTherapeutByEmail("jonas@nydegger")));
        patientManager.save(new Patient("Loris", "Muster", null ,therapeutManager.getTherapeutByEmail("jonas@nydegger")));

        return ok("OK - Patient").build();
    }

    // set all
    @GET
    @Path("/programm")
    public Response doProgrammSettings() {
        Programm programm = new Programm("Programm1");
        ProgrammComponent compo1 = new ProgrammComponent(exerciseManager.getExerciseById(1), programm, 12, 2);
        ProgrammComponent compo2 = new ProgrammComponent(exerciseManager.getExerciseById(3), programm, 8, 2);
        ProgrammComponent compo3 = new ProgrammComponent(exerciseManager.getExerciseById(2), programm, 15, 2);
        programmManager.save(compo1);
        programmManager.save(compo2);
        programmManager.save(compo3);
        programmManager.addProgrammComponentToProgramm(programm, compo1);
        programmManager.addProgrammComponentToProgramm(programm, compo2);
        programmManager.addProgrammComponentToProgramm(programm, compo3);
        programmManager.save(programm);
        return ok("OK - Programm").build();
    }
}
