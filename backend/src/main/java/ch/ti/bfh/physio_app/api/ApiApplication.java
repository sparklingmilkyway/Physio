package ch.ti.bfh.physio_app.api;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationPath("/api")
public class ApiApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return newHashSet(
                HelloWorldResource.class,
                UserResource.class,
                ProgrammExerciseResource.class,
                ApiApplication.class,
                PraxisResource.class,
                CorsFilter.class,
                PatientResource.class
        );
    }
}
