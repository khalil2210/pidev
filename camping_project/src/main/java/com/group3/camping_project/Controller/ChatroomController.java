package com.group3.camping_project.Controller;

import com.group3.camping_project.Services.ChatroomService.IChatroomService;
import com.group3.camping_project.entities.Chatroom;
import com.group3.camping_project.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatroom")
public class ChatroomController {

    @Autowired
    IChatroomService iChatroomService;

    @GetMapping("/getAllChatroom")
    public List<Chatroom> getAllChatroom(){
        return iChatroomService.getAllChatroom();
    }


    @PostMapping("/addChatroom")
    public Chatroom addChatroom(@RequestBody Chatroom chatroom,@RequestParam  int ownerId){
        return iChatroomService.addChatroom(chatroom,ownerId);
    }

    @DeleteMapping("/deleteChatroom/{chatroomId}")
    public void deleteChatroom(@PathVariable int chatroomId){
        iChatroomService.deleteChatroom(chatroomId);
    }


    @PostMapping("/addUserToChatroom")
    public Chatroom addUserToChatroom(int userId, int chatroomId){
        return iChatroomService.addUserToChatroom(userId,chatroomId);
    }

    @DeleteMapping("/removeUserFromChatroom")
    public ResponseEntity<String> removeUserFromChatroom(int userId, int chatroomId){
        return iChatroomService.removeUserFromChatroom(userId,chatroomId);
    }

    @GetMapping("/getUserChatrooms")
    public List<Chatroom> getUserChatrooms(@RequestParam int userId){
        return iChatroomService.getUserChatrooms(userId);
    }


    @GetMapping("/getAllUsersByChatroom")
    public List<User> getAllUsersByChatroom(int chatroomId){
        return iChatroomService.getAllUsersByChatroom(chatroomId);
    }




}
