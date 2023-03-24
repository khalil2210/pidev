package com.group3.camping_project.Services.MessageService;

import com.group3.camping_project.entities.Message;

import java.util.List;

public interface IMessageService {

    public Message addMessage(Message message,int senderId,int chatroomId);

    public void deleteMessage(int idMessage);

    public List<Message> getAllByChatroomId(int chatroomId);

}
