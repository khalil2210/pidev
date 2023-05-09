package com.group3.camping_project.service.message_service;

import com.group3.camping_project.entities.Message;
import com.group3.camping_project.entities.User;

import java.util.List;

public interface IMessageService {

    public Message addMessage(Message message, User senderId, int chatroomId);

    public void deleteMessage(int idMessage);

    public List<Message> getAllByChatroomId(int chatroomId);

}
