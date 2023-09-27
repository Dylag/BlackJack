package com.ssspamqe.BlackJack.newConnectionHandler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Controller
public class ConnectionController {


    ConnectionHandler connectionHandler;

    public ConnectionController(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    @MessageMapping("/connectionHandler")
    @SendTo("/output/connections")
    public List<UserInfo> publishConnection (ConnectionUpdate connectionUpdate){

        //TODO handle wrong state string from client
        System.out.println(connectionUpdate.getUserInfo());
        if(connectionUpdate.getState().equals("connecting"))
            return connectionHandler.addUser(connectionUpdate.getUserInfo());
        else
            return connectionHandler.deleteUser(connectionUpdate.getUserInfo());
    }

//    @MessageMapping("/newConnection")
//    @SendTo("/output/connections")
//    public List<ConnectionInfo> publishConnections(List<ConnectionInfo> connections){
//        System.out.println("got websocket data");
//        System.out.println("sending list of connections with size of " + connections.size());
//        return connections;
//    }




}
