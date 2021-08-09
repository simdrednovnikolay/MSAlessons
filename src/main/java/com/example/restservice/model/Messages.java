package com.example.restservice.model;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Messages {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
