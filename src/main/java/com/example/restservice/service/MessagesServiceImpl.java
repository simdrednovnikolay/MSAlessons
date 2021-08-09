package com.example.restservice.service;

import com.example.restservice.model.Messages;
import com.example.restservice.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    @Override
    public List<Messages> findAll() {
        return messagesRepository.findAll();
    }

    @Override
    public Messages findById(Long id) {
        Optional<Messages> findMessage = messagesRepository.findById(id);
        return findMessage.get();
    }

    @Override
    public Messages createMessage(Messages messages) {
        return messagesRepository.save(messages);
    }


    @Override
    public void deleteMessageById(Long id) {
        messagesRepository.deleteById(id);
    }

    @Override
    public Messages updateMessage(Messages messages) {
        Optional<Messages> updateMes = messagesRepository.findById(messages.getId());
        return messagesRepository.save(updateMes.get());
    }
}
