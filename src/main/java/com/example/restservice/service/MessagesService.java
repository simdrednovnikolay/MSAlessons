package com.example.restservice.service;

import com.example.restservice.model.User;

import java.util.List;

public interface MessagesService {

    List<User> findAll();

    User findById(Long id);

    User createMessage(User messages);

    void deleteMessageById(Long id);

    User updateMessage(User messages);
}
