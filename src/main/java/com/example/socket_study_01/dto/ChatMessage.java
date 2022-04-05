package com.example.socket_study_01.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Builder
public class ChatMessage{
    public enum MessageType{
        ENTER, JOIN, TALK
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
