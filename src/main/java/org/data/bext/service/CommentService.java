package org.data.bext.service;

import org.data.bext.database.DatabaseClass;
import org.data.bext.model.Comment;
import org.data.bext.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    private Map<Long,Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComents(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
       Map<Long, Comment> comments = messages.get(messageId).getComments();
       return comments.get(commentId);
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
