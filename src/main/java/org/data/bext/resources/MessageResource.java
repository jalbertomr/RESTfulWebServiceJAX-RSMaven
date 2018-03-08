package org.data.bext.resources;

import org.data.bext.model.Message;
import org.data.bext.resources.beans.MessageFilterBean;
import org.data.bext.service.MessageService;
import org.glassfish.jersey.server.Uri;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/mensajes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYear() > 0 ) return messageService.getAllMessageForYear(filterBean.getYear());
        if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
            return messageService.getAllMessagePaginated(filterBean.getStart(), filterBean.getSize());
        }
        return messageService.getAllMessages();
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException{
        Message newMessage = messageService.addMessage(message);
        String newMessageId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newMessageId).build();
        return  Response.created(uri)
                .entity(newMessage)
                .build();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id , Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) {
        messageService.removeMessage(id);
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long Id) {
        return messageService.getMessage(Id);
    }

    @Path("/{messageId}/comentarios")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }


}
