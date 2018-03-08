package org.data.bext.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("/annotations")
    public String getParamUsingAnnotations(@MatrixParam("param1") String value,
                                           @MatrixParam("param2") String value2,
                                           @MatrixParam("paramName") long cantidad) {
        return "Matrix Param1:" + value + " param2:" + value2 + " paramName:" + cantidad;
    }
}
