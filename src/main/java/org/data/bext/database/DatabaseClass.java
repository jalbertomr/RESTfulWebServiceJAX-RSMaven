package org.data.bext.database;

import org.data.bext.model.Message;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long,Message> messages = new HashMap<>();
    private static Map<Long,Message.Profile> profiles = new HashMap<>();

    public static Map<Long,Message> getMessages() {
        return messages;
    }

    public static Map<Long,Message.Profile> getProfiles() { return profiles; }
}
