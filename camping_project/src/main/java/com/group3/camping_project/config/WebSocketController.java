package com.group3.camping_project.config;


import com.group3.camping_project.service.ChatroomService.IChatroomService;
import com.group3.camping_project.service.MessageService.IMessageService;
import com.group3.camping_project.entities.Message;
import com.group3.camping_project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    IMessageService iMessageService;
    @Autowired
    IChatroomService iChatroomService;

    @MessageMapping("/sendMessageToChatroom/{chatroomId}")
    // /app/chatroom
    public void messaging(@Payload Message message,@DestinationVariable int chatroomId){
        ////case chatroom exists
        iMessageService.addMessage(message,message.getSender(),chatroomId);
        messagingTemplate.convertAndSend("/chatroom/"+chatroomId, message);
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
