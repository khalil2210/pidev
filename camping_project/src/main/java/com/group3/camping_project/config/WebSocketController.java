package com.group3.camping_project.config;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.service.chatroom_service.IChatroomService;
import com.group3.camping_project.service.file_service.IImageService;
import com.group3.camping_project.service.message_service.IMessageService;
import com.group3.camping_project.entities.Message;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
public class WebSocketController {

    @Autowired
     SimpMessagingTemplate messagingTemplate;
    @Autowired
    IMessageService iMessageService;
    @Autowired
    IChatroomService iChatroomService;
    @Autowired
    IImageService iImageService;

    @Autowired
    IImageRepo iImageRepo;

    @MessageMapping("/sendMessageToChatroom/{chatroomId}")
    // /app/chatroom
    public Message messaging(@Payload Message message,@DestinationVariable int chatroomId){
        ////case chatroom exists
       Message messageToChannel=iMessageService.addMessage(message,message.getSender(),chatroomId);
       messagingTemplate.convertAndSend("/chatroom/"+chatroomId, messageToChannel);
        return messageToChannel;
    }
    @MessageMapping("/sendImageToChatroom")
    // /app/chatroom
    public void messaging(@Payload byte[] data)  {
        Image image= iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(data)).build());
        System.out.println(Arrays.toString(data));
        System.out.println(image.getId());
    }


    @MessageMapping("/addUserToChatroom/{chatroomId}")
    public void Joining(@Payload User user, @DestinationVariable int chatroomId){
        Message message = new Message();
        message.setContent(user.getFirstName() + " has joined the chatroom, Welcome");
        messagingTemplate.convertAndSend("/chatroom/"+chatroomId,message);
        iChatroomService.addUserToChatroom(user.getUsername(),chatroomId);
    }

    //////to be modified
    @MessageMapping("/quit")
    @SendTo("/topic/")
    public Message Exiting(Message message){
        Message m = new Message();
        m.setContent(message.getContent()+" left the chatroom .");
        return m;
    }




}
