package com.ssspamqe.BlackJack.newConnectionHandler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NewConnectionController  {

    @MessageMapping("/newConnection")
    @SendTo("/output/connections")
    public ConnectionInfo handleNewConnection (ConnectionInfo connectionInfo){
        System.out.println("Got new connection");
        System.out.println(connectionInfo);
        return connectionInfo;
    }

}
