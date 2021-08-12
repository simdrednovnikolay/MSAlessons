package com.example.restservice.service;

import com.example.restservice.model.User;
import com.example.restservice.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    @Override
    public List<User> findAll() {
        return messagesRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> findMessage = messagesRepository.findById(id);
        return findMessage.get();
    }

    @Override
    public User createMessage(User messages) {
        return messagesRepository.save(messages);
    }


    @Override
    public void deleteMessageById(Long id) {
        messagesRepository.deleteById(id);
    }

    @Override
    public User updateMessage(User user) {
        Optional<User> updateMes = messagesRepository.findById(user.getId());
        return messagesRepository.save(updateMes.get());
    }
}
