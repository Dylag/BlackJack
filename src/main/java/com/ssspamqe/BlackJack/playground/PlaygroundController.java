package com.ssspamqe.BlackJack.playground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/blackJack/playground")
public class PlaygroundController {
//    @GetMapping(path = "/start")
//    public ArrayList<String> startGame(){
//
//        return PlaygroundService.startGame();
//    }
//
//    @GetMapping(path = "/takeCard")
//    public ArrayList<String> takeCard(){
//        //TODO add started game checker
//        return PlaygroundService.takeCard();
//    }
//
//    @GetMapping(path = "/finishGame")
//    public EndGameResponse finishGame(){
//        // change it, cuz response must be built in controller layer
//        return PlaygroundService.finishGame();
//    }
}
