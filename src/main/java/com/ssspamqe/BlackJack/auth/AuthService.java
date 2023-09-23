package com.ssspamqe.BlackJack.auth;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public String registration(User newUser){
        Optional<User> userWithSameName = authRepository.findByName(newUser.getUsername());

        if(userWithSameName.isPresent())
            return "the name is already taken";
        authRepository.save(newUser);
        return "ok";
    }

    public String login(User user){
        Optional<User> possibleUser = authRepository.findByName(user.getUsername());

        if(possibleUser.isEmpty())
            return "wrong name";
        if(!possibleUser.get().getPassword().equals(user.getPassword()))
            return "wrong password";
        return "ok";
    }
}
