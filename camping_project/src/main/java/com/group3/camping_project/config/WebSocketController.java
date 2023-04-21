package com.group3.camping_project.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.service.ChatroomService.IChatroomService;
import com.group3.camping_project.service.FileService.IImageService;
import com.group3.camping_project.service.MessageService.IMessageService;
import com.group3.camping_project.entities.Message;
import com.group3.camping_project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.BinaryMessage;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    IMessageService iMessageService;
    @Autowired
    IChatroomService iChatroomService;
    @Autowired
    IImageService iImageService;

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
    public void messaging(@Payload Image image) throws IOException {
        System.out.println(image.getImageData()[0]);
    }


    @MessageMapping("/addUserToChatroom/{chatroomId}")
    public void Joining(@Payload User user, @DestinationVariable int chatroomId){
        Message message = new Message();
        message.setContent(user.getFirstName() + " has joined the chatroom, Welcome");
        messagingTemplate.convertAndSend("/chatroom/"+chatroomId,message);
        iChatroomService.addUserToChatroom(user.getId(),chatroomId);
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
