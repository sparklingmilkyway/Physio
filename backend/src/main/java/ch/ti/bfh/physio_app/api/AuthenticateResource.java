package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.concept.UserDTO;
import ch.ti.bfh.physio_app.manager.JWTService;
import ch.ti.bfh.physio_app.manager.LoginManager;
import ch.ti.bfh.physio_app.manager.TherapeutManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.ok;

@Path("/authenticate")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class AuthenticateResource {

    @Inject
    private LoginManager loginManager;

    @Inject
    private TherapeutManager therapeutManager;

    @Inject
    private JWTService jwtService;


    // login
    @POST
    @Path("")
    public Response login(String email, String password) {

        Therapeut therapeut = therapeutManager.getTherapeutByEmail(email);

        if (loginManager.auth(therapeut, password)) {

            String token = jwtService.getSignature(therapeut);
            UserDTO userDTO = new UserDTO(therapeut, token);
            return Response
                    .status(Response.Status.OK)
                    .entity(userDTO)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }

        else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Username or password is incorrect")
                    .type( MediaType.TEXT_PLAIN)
                    .build();
        }
    }



}
