package org.data.bext.resources;

import org.data.bext.model.Message;
import org.data.bext.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/mensajes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @POST
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
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
}
