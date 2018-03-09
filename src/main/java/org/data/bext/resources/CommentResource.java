package org.data.bext.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//@Path("/")    //Path en subresources no es necesario aqui
public class CommentResource {

    @GET
    public String test() {
        return "new subresource test";
    }

    @GET
    @Path("/{commentId}")
    public String getComment(@PathParam("messageId") long messageID,@PathParam("commentId") long commentID) {
        return "comentario a regresar(commentID): " + commentID + " del mensage:" + messageID;
    }
}
