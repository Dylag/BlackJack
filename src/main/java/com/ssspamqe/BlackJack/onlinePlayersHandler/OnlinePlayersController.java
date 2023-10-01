package com.ssspamqe.BlackJack.onlinePlayersHandler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OnlinePlayersController {

//    userInfo:{
//        username:---,
//        role:---,
//        ready:---.
//    }
//    action:---

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
