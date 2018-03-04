package org.data.bext.service;

import org.data.bext.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages() {
        Message m1 = new Message(1L, "primer mensaje", "Beto");
        Message m2 = new Message(2L, "otro mensage", "Vene");
        List<Message> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        return list;
    }
}
