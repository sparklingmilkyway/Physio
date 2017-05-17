package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.LoginManager;
import ch.ti.bfh.physio_app.manager.PatientManager;
import ch.ti.bfh.physio_app.manager.PraxisManager;
import ch.ti.bfh.physio_app.manager.TherapeutManager;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

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

    @Inject
    private LoginManager loginManager;

    // CREATING A NEW PATIENT
    @GET
    @Path("/create/fn={firstname}-sn={surname}-email={email}-pw={password}-therapeut={theraId}")
    public Response createNewPatient(@PathParam("firstname") String firstname,
                               @PathParam("surname") String surname,
                               @PathParam("email")String email,
                               @PathParam("password")String password,
                               @PathParam("theraId")long therapeutID) {
        long id = 1;
        Praxis praxis = praxisManager.getPraxisById(id);
        Therapeut therapeut = therapeutManager.getTherapeutById(therapeutID);
        String passwordHash = loginManager.doHash(password);
        Patient patient = new Patient(firstname, surname, email, passwordHash, therapeut);
        patientManager.save(patient);
        return ok(patient).build();
    }

    // CREATING A NEW PATIENT
    @GET
    @Path("/create/patient={patientID}-{paramtoUpdate}={param}")
    public Response updatePatient(@PathParam("patientID") long id,
                               @PathParam("paramtoUpdate") String paramtoUpdate,
                               @PathParam("param")String param) {

        Patient patient = patientManager.getPatientById(id);
        //patientManager.updatePatient(patient, paramtoUpdate, param);
        return ok(patient).build();
    }




    @GET
    @Path("/add/fn={firstname}/sn={surname}")
    public Response addPatient(@PathParam("firstname") String firstname, @PathParam("surname") String surname) {
        long id = 1;
        Praxis praxis = praxisManager.getPraxisById(id);
        Therapeut therapeut = therapeutManager.getTherapeutById(id);
        Patient patient = new Patient(firstname, surname, "jonas@mail.ch", "pwhs", therapeut);
        patientManager.save(patient);
        return ok(patient).build();
    }

    @GET
    @Path("/get/id={id}")
    public Response getPatient(@PathParam("id") long id){
        Patient patient = patientManager.getPatientById(id);
        return ok(patient).build();
    }

    @GET
    @Path("/get/surname={surname}")
    public Response getPatient(@PathParam("surname") String surname){
        Patient patient = patientManager.getPatientBySurname(surname);
        return ok(patient).build();
    }
    @GET
    @Path("/get/sn={surname}")
    public Response getPatient(@PathParam("surname") String surname){
        List<Patient> patientList = patientManager.getPatientBySurname(surname);
        return ok(patientList).build();
    }

    @GET
    @Path("/get/")
    public List<Patient> getPatients(){
        List<Patient> patientList = patientManager.getAllPatients();
        return patientList;
    }

}
