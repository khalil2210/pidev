package com.group3.camping_project.service.ChatroomService;

import com.group3.camping_project.entities.Chatroom;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IChatroomRepo;
import com.group3.camping_project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatroomServiceImpl implements IChatroomService{

    @Autowired
    IChatroomRepo iChatroomRepo;

    @Autowired
    IUserRepo iUserRepo;

    @Override
    public Chatroom addChatroom(Chatroom chatroom,int ownerId) {
        User owner=iUserRepo.findById(ownerId).get();
        chatroom.setOwner(owner);
        return iChatroomRepo.save(chatroom);
    }

    @Override
    public List<Chatroom> getAllChatroom() {
        return iChatroomRepo.findAll();
    }

    @Override
    public void deleteChatroom(int chatroomId) {
       iChatroomRepo.deleteById(chatroomId);
    }
    @Override
    public Chatroom updateChatroom() {
        return null;
    }

    @Override
    public Chatroom addUserToChatroom(int userId, int chatroomId) {
        User user=iUserRepo.findById(userId).get();
        Chatroom chatroom=iChatroomRepo.findById(chatroomId).get();
        if(user.getChatrooms().contains(chatroom)){
                throw new RuntimeException("user already exists in the chatroom");
        }
        user.getChatrooms().add(chatroom);
        chatroom.getUsers().add(user);
        iUserRepo.save(user);
        iChatroomRepo.save(chatroom);
        return chatroom;
    }

    @Override
    public ResponseEntity<String> removeUserFromChatroom(int userId, int chatroomId) {
        Chatroom chatroom=iChatroomRepo.findById(chatroomId).get();
        User user=iUserRepo.findById(userId).get();
        if(!(chatroom.getUsers().contains(user))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist");}
        chatroom.getUsers().remove(user);
        user.getChatrooms().remove(chatroom);
        iChatroomRepo.save(chatroom);
        iUserRepo.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Removed from Chatroom");
    }

    @Override
    public List<Chatroom> getUserChatrooms(int userId) {
        return iUserRepo.findById(userId).get().getChatrooms();
    }

    @Override
    public List<User> getAllUsersByChatroom(int chatroomId) {
        return iChatroomRepo.findById(chatroomId).get().getUsers();

    }
}
