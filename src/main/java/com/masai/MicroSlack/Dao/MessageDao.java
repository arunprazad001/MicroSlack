package com.masai.MicroSlack.Dao;

import com.masai.MicroSlack.entity.Message;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MessageDao {
    private List<Message> messages = new ArrayList<>();

    @PostConstruct
    public void init() {
        messages.add(new Message(1, 1, "Welcome to placements channel!"));
        messages.add(new Message(2, 2, "This is the crash course related channel."));
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public Optional<Message> getMessageById(int id) {
        return messages.stream().filter(message -> message.getId() == id).findFirst();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void updateMessage(Message message) {
        messages.stream()
                .filter(m -> m.getId() == message.getId())
                .findFirst()
                .ifPresent(m -> {
                    m.setChannelId(message.getChannelId());
                    m.setContent(message.getContent());
                });
    }

    public void deleteMessage(int id) {
        messages.removeIf(message -> message.getId() == id);
    }

}
