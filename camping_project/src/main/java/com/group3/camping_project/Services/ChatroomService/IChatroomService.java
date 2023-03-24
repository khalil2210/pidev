package com.group3.camping_project.Services.ChatroomService;

import com.group3.camping_project.entities.Chatroom;
import com.group3.camping_project.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IChatroomService  {

    public Chatroom addChatroom(Chatroom chatroom,int ownerId);

    public List<Chatroom>getAllChatroom();
    public void deleteChatroom(int chatroomId);

    public Chatroom updateChatroom();

    public Chatroom addUserToChatroom(int userId ,int chatroomId);

    public ResponseEntity<String> removeUserFromChatroom(int userId, int chatroomId);

    public List<Chatroom> getUserChatrooms(int userId);

    public List<User> getAllUsersByChatroom(int chatroomId);


}
