package com.ssspamqe.BlackJack.onlinePlayersHandler;

public class OnlineUsersUpdate extends UserInfo{
    Action action;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public UserInfo getUserInfo(){
        return new UserInfo(getUsername(),getRole());
    }


    @Override
    public String toString(){
        return getUsername() + " " + getRole() + " "+ isReady() + " "+getAction();
    }

}
