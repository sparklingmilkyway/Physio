package ch.ti.bfh.physio_app.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@ApplicationPath("/api")
public class ApiApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return newHashSet(
                UserResource.class,
                ProgrammResource.class,
                PraxisResource.class,
                CorsFilter.class,
                PatientResource.class,
                ExerciseResource.class
        );
    }
}
