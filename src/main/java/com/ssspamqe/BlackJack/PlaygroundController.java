package com.ssspamqe.BlackJack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/blackJack/playground")
public class PlaygroundController {



    private PlaygroundService playgroundService;
    public PlaygroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    @GetMapping(path = "/start")
    public ArrayList<String> startGame(){
        return playgroundService.startGame();
    }

}
