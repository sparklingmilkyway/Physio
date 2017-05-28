package ch.ti.bfh.physio_app.api;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response;

/**
 * Created by Jonas on 28.05.2017.
 */
public class APIExceptionInterceptor {

    @AroundInvoke
    public Object handleException(InvocationContext context){
        Object proceedResponse;
        try{
            proceedResponse = context.proceed();
        } catch(Exception ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
        return proceedResponse;
    }
}
