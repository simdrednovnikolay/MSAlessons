package com.example.restservice.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Messages {

    public List<Map<String,String>> viewMessages = new ArrayList<>() {{
        add(new HashMap<>() {{put("id", "1"); put("text", "first text");}});
        add(new HashMap<>() {{put("id", "2"); put("text", "second text");}});
        add(new HashMap<>() {{put("id", "3"); put("text", "first text");}});
        add(new HashMap<>() {{put("id", "4"); put("text", "fourth text");}});
    }};

}
