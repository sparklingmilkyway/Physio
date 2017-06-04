package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Therapeut;
import ch.ti.bfh.physio_app.manager.LoginManager;
import ch.ti.bfh.physio_app.manager.TherapeutManager;

import javax.inject.Inject;
import javax.ws.rs.*;
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


    // login
    @POST
    @Path("")
    public Response login(String email, String password) {



        /*
        return Response.status(200).h



            // get parameters from post request
            let params = JSON.parse(connection.request.getBody());

            // find if any user matches login credentials
            let filteredUsers = users.filter(user => {
            return user.username === params.username && user.password === params.password;
                });

            if (filteredUsers.length) {
                // if login details are valid return 200 OK with user details and fake jwt token
                let user = filteredUsers[0];
                connection.mockRespond(new Response(new ResponseOptions({
                        status: 200,
                        body: {
                    id: user.id,
                            username: user.username,
                            firstName: user.firstName,
                            lastName: user.lastName,
                            token: 'fake-jwt-token'
                }
                    })));
            } else {
                // else return 400 bad request
                connection.mockError(new Error('Username or password is incorrect'));
            }
            */

        return ok().build();


    }



}
