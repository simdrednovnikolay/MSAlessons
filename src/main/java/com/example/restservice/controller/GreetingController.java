package com.example.restservice.controller;


import com.example.restservice.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class GreetingController {

    private int count = 5;

    @Autowired
    private Messages messages;

    @GetMapping
    public List<Map<String,String>> allMessages() {
        return messages.viewMessages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOneMessageFromId(@PathVariable String id) throws Throwable {
              return messages.viewMessages.stream()
                      .filter(m ->m.get("id").equals(id))
                      .findFirst()
                      .get();

    }

    @PostMapping
    public Map<String,String> createMessage(@RequestBody Map<String,String> newMessage) {
        newMessage.put("id", String.valueOf(count++));
        messages.viewMessages.add(newMessage);
        return  newMessage;
    }

    @PutMapping("{id}")
    public Map<String,String> updateMessage(@PathVariable String id, @RequestBody Map<String,String> newMessage) {
        Map<String,String> updateMessage = messages.viewMessages.stream()
                .filter(m ->m.get("id").equals(id))
                .findFirst()
                .get();
        updateMessage.putAll(newMessage);
        updateMessage.put("id", id);
        return updateMessage;
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id) {
        Map<String,String> deleteMessage = messages.viewMessages.stream()
                .filter(m ->m.get("id").equals(id))
                .findFirst()
                .get();
        messages.viewMessages.remove(deleteMessage);
    }

}
