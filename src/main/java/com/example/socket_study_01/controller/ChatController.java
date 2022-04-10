package com.example.socket_study_01.controller;

import com.example.socket_study_01.dto.ChatMessage;
import com.example.socket_study_01.pubsub.RedisPublisher;
import com.example.socket_study_01.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ChatController {

    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message){
        if(ChatMessage.MessageType.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장!");
        }
        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()),message);
    }
}