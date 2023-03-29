package com.group3.camping_project.Config;


import com.group3.camping_project.entities.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WebSocketController {

    @MessageMapping("/send")
    @SendTo("/topic/")
    public Message messaging(Message message){
        Message m = new Message();
        String sender=message.getSender().getFirstName();
        m.setContent(sender+"  :  "+ message.getContent());
        return m;
    }
    @MessageMapping("/join")
    @SendTo("/topic/")
    public Message Joining(Message message){
        Message m = new Message();
        m.setContent(message.getContent()+" has joined the chatroom , Welcome");
        return m;
    }
    @MessageMapping("/quit")
    @SendTo("/topic/")
    public Message Exiting(Message message){
        Message m = new Message();
        m.setContent(message.getContent()+" left the chatroom .");
        return m;
    }




}
