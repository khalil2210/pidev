package com.group3.camping_project.service.chatroom_service;

import com.group3.camping_project.entities.Chatroom;
import com.group3.camping_project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IChatroomService  {

    public Chatroom addChatroom(Chatroom chatroom, MultipartFile image) throws IOException;

    public List<Chatroom>getAllChatroom();
    public void deleteChatroom(int chatroomId);

    public Chatroom updateChatroom(int chatroomId,MultipartFile image,String chatroomName) throws IOException;



    public Chatroom addUserToChatroom(String username, int chatroomId);

    public ResponseEntity<String> removeUserFromChatroom(String username, int chatroomId);

    public List<Chatroom> getUserChatrooms(int userId);

    public List<User> getAllUsersByChatroom(int chatroomId);


}
