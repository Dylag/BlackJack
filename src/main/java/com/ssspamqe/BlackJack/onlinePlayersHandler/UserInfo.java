package com.ssspamqe.BlackJack.onlinePlayersHandler;

import com.ssspamqe.BlackJack.auth.User;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {

    private String username;
    private String role;
    private boolean ready = false;

    private ArrayList<String> deck = new ArrayList<String>();

    public UserInfo() {
    }

    public UserInfo(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public UserInfo(List<String> data) {
        this.username = data.get(0);
        this.role = data.get(1);
    }

    public void changeReady() {
        ready = !ready;
    }


    @Override
    public String toString() {
        return username + " " + role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
