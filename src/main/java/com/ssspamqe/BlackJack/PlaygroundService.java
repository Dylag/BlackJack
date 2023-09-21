package com.ssspamqe.BlackJack;

import org.springframework.stereotype.Service;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlaygroundService {



    Queue<String> cards;
    ArrayList<String> playerDeck;
    ArrayList<String> dealerDeck;

    ArrayList<String> startGame(){
        cards = new ArrayDeque<String>();
        ArrayList<String> cardSet = new ArrayList<>();
        for(int i =0;i<4;i++)
            cardSet.addAll(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));

        Collections.shuffle(cardSet);

        cardSet.forEach(i->cards.offer(i));


        playerDeck = new ArrayList<String>();
        playerDeck.add(cards.poll());
        playerDeck.add(cards.poll());

        dealerDeck = new ArrayList<String>();
        dealerDeck.add(cards.poll());
        dealerDeck.add(cards.poll());

        return playerDeck;
    }

    ArrayList<String> takeCard(){
        //TODO add card availability checker
        playerDeck.add(cards.poll());
        return playerDeck;
    }


    EndGameResponse finishGame(){
        int dealerPoints = getPointsOfList(dealerDeck);
        int playerPoints = getPointsOfList(playerDeck);

        String winner = "none";

        if((dealerPoints > 21) && (playerPoints > 21) || (dealerPoints == playerPoints))
            winner = "draw";

        else if(dealerPoints > 21)
            winner = "player";

        else if(playerPoints > 21)
            winner = "dealer";

        else if(playerPoints > dealerPoints)
            winner = "player";

        else
            winner = "dealer";

        return new EndGameResponse(winner, dealerDeck);
    }


    int getPointsOfList(ArrayList<String> deck){
        int res =0;
        int ACount = (int) deck.stream().filter(i -> i.equals("A")).count();

        for(var i : deck)
            if(!i.equals("A"))
                res+=getPoints(i);


        if(ACount==0)
            return res;
        //ДО ПОСТКОММУНАРКИ 15 МИНУУУУУУт

        if(res + 10 + ACount <= 21)
            return res + 10 + ACount;
        else
            return res+ACount;

        //5 МИНУТ ААААААААААААААААААААААААААААААААААА

    }

    int getPoints(String s){
        try{
            return Integer.parseInt(s);
        } catch (Exception ex){
            return 10;
        }
    }

    ArrayList<String> getPlayerDeck(){
        return playerDeck;
    }

    ArrayList<String> getDealerDeck(){
        return dealerDeck;
    }

}
