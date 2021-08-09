package com.example.restservice.service;

import com.example.restservice.model.Messages;

import java.util.List;

public interface MessagesService {

    List<Messages> findAll();

    Messages findById(Long id);

    Messages createMessage(Messages messages);

    void deleteMessageById(Long id);

    Messages updateMessage(Messages messages);
}
