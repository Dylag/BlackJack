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
        cardSet.forEach(i->cards.offer(i));

        playerDeck.add(cards.poll());
        playerDeck.add(cards.poll());

        dealerDeck.add(cards.poll());
        dealerDeck.add(cards.poll());

        return playerDeck;
    }

    int getPointsOfList(ArrayList<String> deck){
        AtomicInteger res = new AtomicInteger();
        deck.forEach(i-> res.addAndGet(getPoints(i))); //Whats the "AtomicInteger" is and why i should use it here??????????s
        return res.get();
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
