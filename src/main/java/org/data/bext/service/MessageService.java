package org.data.bext.service;

import org.data.bext.database.DatabaseClass;
import org.data.bext.model.Message;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    private Map<Long,Message> messages = DatabaseClass.getMessages();

    /*public List<Message> getAllMessages() {
        Message m1 = new Message(1L, "primer mensaje", "Beto");
        Message m2 = new Message(2L, "otro mensage", "Vene");
        List<Message> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        return list;
    }*/

    public MessageService() {
        messages.put(1L, new Message(1, "primer mensaje","Beto"));
        messages.put(2L, new Message(2, "otro mensaje","Vene"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessageForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message message: messages.values()) {
            cal.setTime(message.getCreated());
            if (cal.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagePaginated(int start, int size) {
        ArrayList<Message> list = new ArrayList<>(messages.values());
        if ((start + size) > list.size()) return new ArrayList<Message>();
        return list.subList(start, start + size);
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
