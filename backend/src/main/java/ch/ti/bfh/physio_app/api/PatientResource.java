package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Patient;
import ch.ti.bfh.physio_app.concept.Praxis;
import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.LoginManager;
import ch.ti.bfh.physio_app.manager.PatientManager;
import ch.ti.bfh.physio_app.manager.PraxisManager;
import ch.ti.bfh.physio_app.manager.TherapeutManager;
import com.sun.org.apache.regexp.internal.RE;


import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("/patient")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PatientResource{

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
    @Path("/create/fn={firstname}/sn={surname}/email={email}/pw={password}/therapeut={theraId}")
    public Response createNewPatient( @PathParam("firstname") String firstname,
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

    // UPDATING A PATIENT
    @GET
    @Path("/update/id={patientId}/fn={firstname}/sn={surname}/email={email}/therapeut={theraId}")
    public Response createNewPatient(@PathParam("patientId") long patientID,
                                     @PathParam("firstname") String firstname,
                                     @PathParam("surname") String surname,
                                     @PathParam("email")String email,
                                     @PathParam("theraId")long therapeutID) {
        Therapeut therapeut = therapeutManager.getTherapeutById(therapeutID);
        Patient patient = patientManager.updatePatient(patientID, firstname, surname, email, therapeut);
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
        try {
            Patient patient = patientManager.getPatientById(id);
            return ok(patient).build();
        } catch(Exception ex){
            /*Response error = Response.serverError().entity(ex.getMessage()).build();
            String x = error.toString();*/
            Patient patient = new Patient();
            patient.setSurname("Kein Patient mit dieser ID gefunden...");
            patient.setFirstname("");
            return ok(patient).build();
        }
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

    @GET
    @Path("/remove/id={id}")
    public boolean removePatient(@PathParam("id") long id){
        return patientManager.removePatient(id);
    }
}
