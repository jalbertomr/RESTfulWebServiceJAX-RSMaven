package org.data.bext.resources;

import org.data.bext.model.Comment;
import org.data.bext.service.CommentService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")    //Path en subresources no es necesario aqui, pero para objener su .path(Class,String) si es necesario
public class CommentResource {
    CommentService commentService = new CommentService();

    @GET
    public String test() {
        return "new subresource test";
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") long messageID, @PathParam("commentId") long commentID) {
        return commentService.getComment(messageID,commentID);
    }
}
