package ch.ti.bfh.physio_app.api;

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
                PraxisResource.class,
                CorsFilter.class,
                PatientResource.class,
                ExerciseResource.class,
                JacksonJsonProvider.class
        );
    }
}
