package com.ssspamqe.BlackJack.onlinePlayersHandler;

import com.ssspamqe.BlackJack.playground.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OnlinePlayersController {


    @Autowired
    private SimpUserRegistry userRegistry;
    @MessageMapping("/onlinePlayers")
    @SendTo("/output/onlinePlayers")
    public List<UserInfo> updateOnlinePlayersList(OnlineUsersUpdate update){
        System.out.println(update);
        switch (update.getAction()){
            case CONNECTING -> {
                return OnlineUsers.addUser(update.getUserInfo());
            }
            case DISCONNECTING ->{
                return OnlineUsers.deleteUser(update.getUserInfo());
            }
            case CHANGING_READY_STATE -> {
                return OnlineUsers.changeReadyState(update.getUserInfo());
            }
        }

        return OnlineUsers.getListOfOnlineUsers();
    }
}
