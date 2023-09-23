package com.ssspamqe.BlackJack.auth;

import com.ssspamqe.BlackJack.StringResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/blackJack/auth")
public class AuthController {

    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/registration")
    public StringResponse registration(@RequestBody User newUser){
        return  new StringResponse(authService.registration(newUser));
    }

    @PostMapping(path = "/login")
    public StringResponse login(@RequestBody User user){
        return new StringResponse(authService.login(user));
    }



}
