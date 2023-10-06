package com.ssspamqe.BlackJack.playground;

import com.ssspamqe.BlackJack.onlinePlayersHandler.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class PlaygroundService {

    @Autowired
    private static SimpMessagingTemplate messagingTemplate;


    private static Map<String,ArrayList<String>> playersDecks = new HashMap<>();
    private static ArrayList<String> dealerDeck = new ArrayList<>();
    private static String dealerUsername;


    private static Queue<String> cards;
    private static ArrayList<String> playerDeck;

    public static void startGame(Map<String, UserInfo> onlineUsers){




        for (var i : onlineUsers.entrySet()){
            if(i.getValue().getRole().equals("player"))
                playersDecks.put(i.getKey(),new ArrayList<String>());
            else
                dealerUsername = i.getKey();
        }

        cards = new ArrayDeque<String>();
        ArrayList<String> cardSet = new ArrayList<>();
        for(int i =0;i<4;i++)
            cardSet.addAll(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));

        Collections.shuffle(cardSet);

        cardSet.forEach(i->cards.offer(i));

        dealerDeck.add(cards.poll());
        dealerDeck.add(cards.poll());

        for(var i:playersDecks.entrySet())
        {
            i.getValue().add(cards.poll());
            i.getValue().add(cards.poll());
        }

        messagingTemplate.convertAndSend("");

    }

    static ArrayList<String> takeCard(){
        //TODO add card availability checker
        playerDeck.add(cards.poll());
        return playerDeck;
    }


    static EndGameResponse finishGame(){
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


    static int getPointsOfList(ArrayList<String> deck){
        int res =0;
        int ACount = (int) deck.stream().filter(i -> i.equals("A")).count();

        for(var i : deck)
            if(!i.equals("A"))
                res+=getPoints(i);


        if(ACount==0)
            return res;
        if(res + 10 + ACount <= 21)
            return res + 10 + ACount;
        else
            return res+ACount;
    }

    static int getPoints(String s){
        try{
            return Integer.parseInt(s);
        } catch (Exception ex){
            return 10;
        }
    }

    static ArrayList<String> getPlayerDeck(){
        return playerDeck;
    }

    static ArrayList<String> getDealerDeck(){
        return dealerDeck;
    }
}
