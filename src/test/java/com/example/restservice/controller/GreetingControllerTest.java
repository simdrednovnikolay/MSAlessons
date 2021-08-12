package com.example.restservice.controller;

import com.example.restservice.service.MessagesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessagesService service;

    @Test
    public void givenAllMessages() throws Exception {
        Messages testMessage = new Messages();
        testMessage.setMessage("First Message");

        List<Messages> messages = List.of(testMessage);

        given(service.findAll()).willReturn(messages);

        RequestBuilder builder = MockMvcRequestBuilders.get("/messages");
        MvcResult result = mockMvc.perform(builder).andReturn();
        assertEquals(testMessage, result.getResponse().getContentAsString());
    }

}