package com.ssspamqe.BlackJack.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping
    @SendTo("/output")
    public Message sendMessage(Message message){

        System.out.println(message);

        return message;

    }

}
