package com.example.restservice.repository;

import com.example.restservice.model.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessagesRepository extends CrudRepository<Messages, Long> {

    List<Messages> findAll();

    Optional<Messages> findById(Long id);

}
