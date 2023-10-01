package com.ssspamqe.BlackJack.onlinePlayersHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TODO change to postgres??????
public class OnlineUsers {

    static private final Map<String, UserInfo> onlineUsers = new HashMap<>();

    public static List<UserInfo> addUser(UserInfo newUser){
        onlineUsers.put(newUser.getUsername(), newUser);
        System.out.println(onlineUsers);
        return new ArrayList<>(onlineUsers.values());
    }

    public static List<UserInfo> deleteUser(UserInfo user){
        onlineUsers.remove(user.getUsername());
        System.out.println(onlineUsers);
        return new ArrayList<>(onlineUsers.values());
    }

    public static Map<String, UserInfo> getOnlineUsers(){
        return onlineUsers;
    }

    public static List<UserInfo> changeReadyState(UserInfo user){
        if(onlineUsers.containsKey(user.getUsername())){
            boolean currentState = onlineUsers.get(user.getUsername()).isReady();
            onlineUsers.get(user.getUsername()).setReady(!currentState);
        }

        return new ArrayList<>(onlineUsers.values());
    }

    public static List<UserInfo> getListOfOnlineUsers(){
        return new ArrayList<>(onlineUsers.values());
    }

}
