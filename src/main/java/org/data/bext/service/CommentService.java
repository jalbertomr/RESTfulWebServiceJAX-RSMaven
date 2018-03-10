package org.data.bext.service;

import org.data.bext.database.DatabaseClass;
import org.data.bext.model.Comment;
import org.data.bext.model.ErrorMessage;
import org.data.bext.model.Message;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long,Message> messages = DatabaseClass.getMessages();

    public CommentService() {
        ;
    }

    public List<Comment> getAllComents(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Message message = messages.get(messageId);
        ErrorMessage errorMessage = new ErrorMessage("No hallado",404,"https://www.blogger.com/jalbertomr");
        Response response = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
        System.out.println(message);
        if (message == null) {
            throw new WebApplicationException(response);
        }
        Map<Long, Comment> comments = message.getComments();
        Comment comment = comments.get(commentId);
        if (comment == null) {
            throw new NotFoundException(response);
        }
        return comment;
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0 ) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment remove(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(comment.getId());
    }
}
