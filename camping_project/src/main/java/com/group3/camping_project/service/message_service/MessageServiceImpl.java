package com.group3.camping_project.service.message_service;

import com.group3.camping_project.entities.Chatroom;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.Message;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IChatroomRepo;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IMessageRepo;
import com.group3.camping_project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    IMessageRepo iMessageRepo;
    @Autowired
    IChatroomRepo iChatroomRepo;
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    IImageRepo iImageRepo;

    private List<String> badWords = Arrays.asList("bad","badd","baad","badd","baaaad","baadd", "ugly","uglyy","uglyyy","uggly", "nasty", "nastyy", "nastyyy","naasty"); // list of bad words


    @Override
    public Message addMessage(Message message,User senderId,int chatroomId) {
        //User sender=iUserRepo.findById(senderId).get();
        if(message.getImage()!=null){
            Image image=message.getImage();
            iImageRepo.save(image);
        }
        Chatroom chatroom=iChatroomRepo.findById(chatroomId).get();
        message.setSender(message.getSender());
        message.setChatroom(chatroom);
        for (String word : badWords) {
            message.setContent(message.getContent().replaceAll("(?i)" + word, "***"));
        }
       return  iMessageRepo.save(message);
    }

    @Override
    public void  deleteMessage(int idMessage) {
         iMessageRepo.deleteById(idMessage);
    }

    @Override
    public List<Message> getAllByChatroomId(int chatroomId) {
        return iMessageRepo.findByChatroom_Id(chatroomId);
    }
}
