package com.group3.camping_project.service.chatroom_service;

import com.group3.camping_project.entities.Chatroom;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IChatroomRepo;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ChatroomServiceImpl implements IChatroomService{

    @Autowired
    IChatroomRepo iChatroomRepo;

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    IImageRepo iImageRepo;

    @Override
    public Chatroom addChatroom(Chatroom chatroom,MultipartFile image) throws IOException {
        Image imageR= iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(image.getBytes())).build());
        chatroom.setImage(imageR);
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
    public Chatroom addUserToChatroom(String username, int chatroomId) {
        User user=iUserRepo.findByUsername(username).get();
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
    public ResponseEntity removeUserFromChatroom(String username, int chatroomId) {
        Chatroom chatroom=iChatroomRepo.findById(chatroomId).get();
        User user=iUserRepo.findByUsername(username).get();
        if(!(chatroom.getUsers().contains(user))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        chatroom.getUsers().remove(user);
        user.getChatrooms().remove(chatroom);
        iChatroomRepo.save(chatroom);
        iUserRepo.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    public List<Chatroom> getUserChatrooms(int userId)
    {

        return iUserRepo.findById(userId).get().getChatrooms();
    }

    @Override
    public List<User> getAllUsersByChatroom(int chatroomId) {
        return iChatroomRepo.findById(chatroomId).get().getUsers();

    }
}
