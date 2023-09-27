package com.ssspamqe.BlackJack.newConnectionHandler;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConnectionHandler {
    //private final Set<UserInfo> onlineUsers = new HashSet<>();
    private final Map<String, String> onlineUsers = new HashMap<>();

    List<UserInfo> addUser (UserInfo newUser){
        onlineUsers.put(newUser.getUsername(), newUser.getRole());
        System.out.println(onlineUsers);
        return onlineUsers.keySet().stream()
                .map(i->new UserInfo(i, onlineUsers.get(i)))
                .collect(Collectors.toList());
    }

    List<UserInfo> deleteUser(UserInfo user){
        onlineUsers.remove(user.getUsername());
        System.out.println(onlineUsers);
        return onlineUsers.keySet().stream()
                .map(i->new UserInfo(i, onlineUsers.get(i)))
                .collect(Collectors.toList());
    }



}
