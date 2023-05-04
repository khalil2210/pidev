package com.group3.camping_project.controller;

import com.group3.camping_project.service.MessageService.IMessageService;
import com.group3.camping_project.entities.Message;
import com.group3.camping_project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    IMessageService iMessageService;

    @PostMapping("addMessage")
    public Message addMessage(@RequestBody Message message, @RequestParam User senderId, @RequestParam int chatroomId){
       return iMessageService.addMessage(message,senderId,chatroomId);
    }

    @DeleteMapping("deleteMessage/{idMessage}")
    public void deleteMessage(@PathVariable int idMessage){
         iMessageService.deleteMessage(idMessage);
    }


    @GetMapping("/getAllByChatroom/{chatroomId}")
    public List<Message> getAllByChatroom(@PathVariable int chatroomId){
        return iMessageService.getAllByChatroomId(chatroomId);
    }
}
