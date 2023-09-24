package com.ssspamqe.BlackJack.newConnectionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class NewConnectionController  {

//    @MessageMapping("/newConnection")
//    @SendTo("/output/connections")
//    public ConnectionInfo handleNewConnection (ConnectionInfo connectionInfo){
//        System.out.println(connectionInfo);
//        return connectionInfo;
//    }

    @SendTo("/output/connections")
    public List<ConnectionInfo> publishConnections(List<ConnectionInfo> connections){
        return connections;
    }



}
