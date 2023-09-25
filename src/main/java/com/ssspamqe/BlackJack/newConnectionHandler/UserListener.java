package com.ssspamqe.BlackJack.newConnectionHandler;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

import java.util.*;

@Component
public class UserListener {

    private final Map<UUID,List<String>> onlineUsers = new HashMap<>();
    @EventListener
    public void handleSessionSubscribeEvent(SessionSubscribeEvent event){
//        System.out.println(headers);
//        Pattern pattern = Pattern.compile("\\\"username\\\":\\\"(\\w+)\\\""); //WHY ITS NOT WORKING???????????????????????
//        Matcher matcher = pattern.matcher(headers);
//        System.out.println(matcher.matches());

        //YEAH I KNOW ABOUT REGEXS BUT THEY ARE NOT WORKING IDK WHY =(
        //TODO use regex
        List<String> connectionData = parseConnectionData(event.getMessage().getHeaders().toString());
        onlineUsers.put(UUID.fromString(connectionData.get(0)), connectionData.subList(1,3));
        System.out.println(onlineUsers.size());


    }

    @EventListener
    public void handleSessionUnsubscribeEvent(SessionUnsubscribeEvent event){
        //System.out.println(event.getMessage().getHeaders().get("nativeHeaders").toString());

        onlineUsers.remove(UUID.fromString(parseSessionUUID(event.getMessage().getHeaders().toString())));
        System.out.println(onlineUsers.size());
    }

    public void printUsers(){
        System.out.println(onlineUsers);
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
        return new ArrayList<String>(List.of(parseSessionUUID(s),username,role));
    }

    public String parseSessionUUID(String s){
        int i = s.indexOf("simpSessionId=") + "simpSessionId=".length();


        String uuid = "";
        while(s.charAt(i)!=',' && s.charAt(i)!='}'){
            uuid+=s.charAt(i);
            i++;
        }
        System.out.println(uuid);
        return uuid;
    }


}
