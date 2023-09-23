package com.ssspamqe.BlackJack.playground;

import java.util.ArrayList;

public class EndGameResponse {

    private String winner;


    private ArrayList<String> dealerDeck;

    public EndGameResponse(String winner, ArrayList<String> dealerDeck) {
        this.winner = winner;
        this.dealerDeck = dealerDeck;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public ArrayList<String> getDealerDeck() {
        return dealerDeck;
    }

    public void setDealerDeck(ArrayList<String> dealerDeck) {
        this.dealerDeck = dealerDeck;
    }
}
