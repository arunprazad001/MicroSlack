package com.masai.MicroSlack.controller;

import com.masai.MicroSlack.entity.Message;
import com.masai.MicroSlack.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessageById(@PathVariable int id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    public void addMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }

    @PutMapping("/{id}")
    public void updateMessage(@PathVariable int id, @RequestBody Message message) {
        message.setId(id);
        messageService.updateMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        messageService.deleteMessage(id);
    }
}