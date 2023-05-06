package com.group3.camping_project.controller;

import com.group3.camping_project.service.equipement_service.Chatservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    Chatservice chatservice;
    @PostMapping("/chat")
    public String chat(@RequestParam String message) {
        String response = chatservice.chat(message);
        return response;
    }

}
