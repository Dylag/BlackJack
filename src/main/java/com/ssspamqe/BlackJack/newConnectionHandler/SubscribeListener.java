//package com.ssspamqe.BlackJack.newConnectionHandler;
//
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionSubscribeEvent;
//import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Component
//public class SubscribeListener {
//
//    private final Map<UUID,List<String>> onlineUsers = new HashMap<>();
//
//    private ConnectionController connectionController;
//
//    SubscribeListener(ConnectionController connectionController){
//        this.connectionController = connectionController;
//    }
//
//    @EventListener
//    public void handleSessionSubscribeEvent(SessionSubscribeEvent event){
////        System.out.println(headers);
////        Pattern pattern = Pattern.compile("\\\"username\\\":\\\"(\\w+)\\\""); //WHY ITS NOT WORKING???????????????????????
////        Matcher matcher = pattern.matcher(headers);
////        System.out.println(matcher.matches());
//
//        //YEAH I KNOW ABOUT REGEXS BUT THEY ARE NOT WORKING IDK WHY =(
//        //TODO use regex
//        List<String> connectionData = parseConnectionData(event.getMessage().getHeaders().toString());
//        if(!onlineUsers.containsKey(UUID.fromString(connectionData.get(0)))){
//            onlineUsers.put(UUID.fromString(connectionData.get(0)), connectionData.subList(1,3));
//            sendOnlineUsers();
//        }
//    }
//
//    @EventListener
//    public void handleSessionUnsubscribeEvent(SessionUnsubscribeEvent event){
//        //System.out.println(event.getMessage().getHeaders().get("nativeHeaders").toString());
//        UUID sessionUUID = UUID.fromString(parseSessionUUID(event.getMessage().getHeaders().toString()));
//
//        if(onlineUsers.containsKey(sessionUUID)) {
//            onlineUsers.remove(UUID.fromString(parseSessionUUID(event.getMessage().getHeaders().toString())));
//            sendOnlineUsers();
//        }
//    }
//
//    //TODO change this shit, perhaps it will be better to delete onlineUsers HashMap?
//    public void sendOnlineUsers(){
//        System.out.println("sending online info from Listener class");
////        connectionController.publishConnections(onlineUsers.values().stream()
////                .map(UserInfo::new).collect(Collectors.toList()));
//    }
//
//    public void send(){
//        ArrayList<MessageChannel> channels = new ArrayList<MessageChannel>();
//        SimpMessagingTemplate messagingTemplate = new SimpMessagingTemplate(new MessageChannel() {
//            @Override
//            public boolean send(Message<?> message, long timeout) {
//                return false;
//            }
//        });
//
//        messagingTemplate.convertAndSend("/output/connections",onlineUsers);
//    }
//
//    public List<String> parseConnectionData(String s){
//        int i = s.indexOf("username") + "username".length()+3;
//        String username = "";
//        while(s.charAt(i) != '\"'){
//            username+=s.charAt(i);
//            i++;
//        }
//        i+=10;
//        String role ="";
//        while(s.charAt(i) != '\"'){
//            role+=s.charAt(i);
//            i++;
//        }
//        return new ArrayList<String>(List.of(parseSessionUUID(s),username,role));
//    }
//
//    public String parseSessionUUID(String s){
//        int i = s.indexOf("simpSessionId=") + "simpSessionId=".length();
//
//
//        String uuid = "";
//        while(s.charAt(i)!=',' && s.charAt(i)!='}'){
//            uuid+=s.charAt(i);
//            i++;
//        }
//        return uuid;
//    }
//}