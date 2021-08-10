package com.example.restservice.controller;


import com.example.restservice.model.Messages;
import com.example.restservice.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class GreetingController {


    @Autowired
    private MessagesService messagesService;

    @GetMapping
    public List<Messages> allMessages() {
        return messagesService.findAll();
    }

    @GetMapping("{id}")
    public Messages getOneMessageFromId(@PathVariable String id) {
              return messagesService.findById(Long.parseLong(id));

    }

    @PostMapping
    public Messages createMessage(@RequestBody Messages newMessage) {
        return  messagesService.createMessage(newMessage);
    }

    @PutMapping("{id}")
    public Messages updateMessage(@PathVariable String id) {
        return messagesService.updateMessage(messagesService.findById(Long.parseLong(id)));
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id) {
        messagesService.deleteMessageById(Long.parseLong(id));
    }

}
