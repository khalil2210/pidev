package com.group3.camping_project.Controller;

import com.group3.camping_project.Services.MessageService.IMessageService;
import com.group3.camping_project.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    IMessageService iMessageService;

    @PostMapping("addMessage")
    public Message addMessage(@RequestBody Message message,@RequestParam int senderId,@RequestParam int chatroomId){
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
