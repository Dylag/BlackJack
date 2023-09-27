package com.ssspamqe.BlackJack.newConnectionHandler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ConnectionController {

//    @MessageMapping("/newConnection")
//    @SendTo("/output/connections")
//    public ConnectionInfo handleNewConnection (ConnectionInfo connectionInfo){
//        System.out.println(connectionInfo);
//        return connectionInfo;
//    }

    @MessageMapping("/newConnection")
    @SendTo("/output/connections")
    public List<ConnectionInfo> publishConnections(List<ConnectionInfo> connections){
        System.out.println("got websocket data");
        System.out.println("sending list of connections with size of " + connections.size());
        return connections;
    }



}
