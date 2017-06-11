package ch.ti.bfh.physio_app.api;

import ch.ti.bfh.physio_app.concept.Therapeut;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@ApplicationPath("/api")
public class ApiApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return newHashSet(
                ProgrammResource.class,
                AuthenticateResource.class,
                PraxisResource.class,
                PatientResource.class,
                ProgrammResource.class,
                TherapeutResource.class,
                ExerciseResource.class,
                JacksonJsonProvider.class,
                CorsFilter.class,
                TestResource.class
        );
    }
}
