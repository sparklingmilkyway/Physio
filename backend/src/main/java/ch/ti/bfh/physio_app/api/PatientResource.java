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

/**
 * This is the REST ressource for all patient calls from the angular frontend which go to our jboss server.
 *
 */
@Path("/patient")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PatientResource{

    @Inject
    private PatientManager patientManager;


    // CREATING A NEW PATIENT
    @POST
    @Path("")
    public Response createNewPatient(Patient patient) {
        patientManager.save(patient);
        return ok(patient).build();
    }

    // UPDATING A NEW PATIENT
    @POST
    @Path("/update")
    public Response updatePatient(Patient patient) {
       // patientManager.updatePatient(patient);
        return ok(patient).build();
    }


    // get a patient by ID
    @GET
    @Path("/{id}")
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

    // get a patient by surname
    @GET
    @Path("/sn={surname}")
    public Response getPatient(@PathParam("surname") String surname){
        List<Patient> patientList = patientManager.getPatientBySurname(surname);
        return ok(patientList).build();
    }

    // get all patients
    @GET
    @Path("/all")
    public List<Patient> getPatients(){
        List<Patient> patientList = patientManager.getAllPatients();
        return patientList;
    }

    // get all patients
    @GET
    @Path("/all/{therapeutID}")
    public List<Patient> getPatients(@PathParam("therapeutID") long therapeutID){
        List<Patient> patientList = patientManager.getAllPatientsOfTherapeut(therapeutID);
        return patientList;
    }

    // remove patient
    @GET
    @Path("/remove/{id}")
    public boolean removePatient(@PathParam("id") long id){
        return patientManager.removePatient(id);
    }
}
