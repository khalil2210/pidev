package com.group3.camping_project.controller;

import com.group3.camping_project.service.chatroom_service.IChatroomService;
import com.group3.camping_project.entities.Chatroom;
import com.group3.camping_project.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chatroom")
public class ChatroomController {

    @Autowired
    IChatroomService iChatroomService;

    @GetMapping("/getAllChatroom")
    public List<Chatroom> getAllChatroom(){
        return iChatroomService.getAllChatroom();
    }


    @PostMapping("/addChatroom")

    public Chatroom addChatroom(@RequestPart Chatroom chatroom, @RequestParam MultipartFile file) throws IOException {
        return iChatroomService.addChatroom(chatroom,file);
    }

    @DeleteMapping("/deleteChatroom/{chatroomId}")
    public void deleteChatroom(@PathVariable int chatroomId){
        iChatroomService.deleteChatroom(chatroomId);
    }


    @PostMapping("/addUserToChatroom")
    public Chatroom addUserToChatroom(@RequestParam String username,@RequestParam int chatroomId){
        return iChatroomService.addUserToChatroom(username,chatroomId);
    }

    @DeleteMapping ("/removeUserFromChatroom")
    public ResponseEntity<String> removeUserFromChatroom(@RequestParam String username,@RequestParam int chatroomId){
        return iChatroomService.removeUserFromChatroom(username,chatroomId);
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
