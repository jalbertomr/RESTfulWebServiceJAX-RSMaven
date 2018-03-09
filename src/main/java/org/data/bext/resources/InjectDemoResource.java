package org.data.bext.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.spi.http.HttpContext;
import java.net.URI;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("/annotations")
    public String getParamUsingAnnotations(@MatrixParam("param1") String value,
                                           @HeaderParam("customHeaderParam") String headerValue,
                                           @CookieParam("cookieName") String valorCookie) {
        return "Matrix Param1:" + value + "customHeaderParam:" + headerValue + "cookieName" + valorCookie;
    }

    @GET
    @Path("/context")
    public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return "Path: " + path + " Cookies: " + cookies;
    }
}
