package com.ssspamqe.BlackJack.newConnectionHandler;

public class ConnectionUpdate {
    private UserInfo userInfo;
    private String state;

    public ConnectionUpdate(UserInfo userInfo, String state) {
        this.userInfo = userInfo;
        this.state = state;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
