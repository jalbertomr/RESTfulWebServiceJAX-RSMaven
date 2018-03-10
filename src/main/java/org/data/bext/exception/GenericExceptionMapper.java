package org.data.bext.exception;

import org.data.bext.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider //deshabilitamos el mapper para probar WebApplicationException de jersey
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "https://www.blogger.com/jalbertomr");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorMessage)
                .build();
    }
}
