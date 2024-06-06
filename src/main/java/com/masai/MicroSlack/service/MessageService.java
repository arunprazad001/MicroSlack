package com.masai.MicroSlack.service;

import com.masai.MicroSlack.Dao.MessageDao;
import com.masai.MicroSlack.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {
    private final MessageDao messageDAO;

    @Autowired
    public MessageService(MessageDao messageDAO) {
        this.messageDAO = messageDAO;
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Optional<Message> getMessageById(int id) {
        return messageDAO.getMessageById(id);
    }

    public void addMessage(Message message) {
        messageDAO.addMessage(message);
    }

    public void updateMessage(Message message) {
        messageDAO.updateMessage(message);
    }

    public void deleteMessage(int id) {
        messageDAO.deleteMessage(id);
    }
}
