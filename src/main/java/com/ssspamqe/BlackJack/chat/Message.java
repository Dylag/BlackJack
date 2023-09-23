package com.ssspamqe.BlackJack.chat;


public class Message {

    private String sender;
    private String content;
    private String senderRole;

    public Message(String sender, String content, String senderRole) {
        this.sender = sender;
        this.content = content;
        this.senderRole = senderRole;
    }

    @Override
    public String toString(){
        return String.format("%s[%s]: \"%s\"", sender, senderRole, content);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderRole() {
        return senderRole;
    }

    public void setSenderRole(String senderRole) {
        this.senderRole = senderRole;
    }
}
