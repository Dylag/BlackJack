package com.ssspamqe.BlackJack.newConnectionHandler;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserListener {

    private final Map<String,String> users = new HashMap<>();
    @EventListener
    public void handleSessionSubscribeEvent(SessionSubscribeEvent event){
//        System.out.println(headers);
//        Pattern pattern = Pattern.compile("\\\"username\\\":\\\"(\\w+)\\\""); //WHY ITS NOT WORKING???????????????????????
//        Matcher matcher = pattern.matcher(headers);
//        System.out.println(matcher.matches());

        //YEAH I KNOW ABOUT REGEXS BUT THEY ARE NOT WORKING IDK WHY =(
        List<String> connectionData = parseConnectionData(event.getMessage().getHeaders().get("nativeHeaders").toString());
        users.put(connectionData.get(0),connectionData.get(1));
        System.out.println(users.size());
    }

    @EventListener
    public void handleSessionUnsubscribeEvent(SessionUnsubscribeEvent event){
        System.out.println(event.getMessage().getHeaders().get("nativeHeaders").toString());
//        List<String> connectionData = parseConnectionData(event.getMessage().getHeaders().get("nativeHeaders").toString());
//        users.remove(connectionData.get(0));
//        System.out.println(users.size());
    }

    public void printUsers(){
        System.out.println(users);
    }

    public List<String> parseConnectionData(String s){
        int i = s.indexOf("username") + "username".length()+3;
        String username = "";
        while(s.charAt(i) != '\"'){
            username+=s.charAt(i);
            i++;
        }
        i+=10;
        String role ="";
        while(s.charAt(i) != '\"'){
            role+=s.charAt(i);
            i++;
        }

        return new ArrayList<String>(List.of(username,role));
    }

}
