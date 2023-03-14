package com.example.web4.controllers;

import com.example.web4.dtos.UserAuthenticationDto;
import com.example.web4.dtos.UserCredentialsDto;
import com.example.web4.dtos.UserResponseDto;
import com.example.web4.entities.User;
import com.example.web4.services.JwtService;
import com.example.web4.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public UserAuthenticationDto registerUser(@RequestBody @Valid UserCredentialsDto userCredentialsDto) {
        String message= "success";
        User user = new User();
        if (userService.findByUsername(userCredentialsDto.getUsername()).isPresent()) {
            message = "Login is already in use";
            user = userService.findByUsername(userCredentialsDto.getUsername()).get();
        }
        else {
            user.setUsername(userCredentialsDto.getUsername());
            user.setPassword(userCredentialsDto.getPassword());
            user = userService.registerUser(user);
        }
        return new UserAuthenticationDto(
                user.getId(),
                user.getUsername(),
                jwtService.createJwtToken(user),
                message
        );
    }

    @PostMapping("/login")
    public UserAuthenticationDto login(@RequestBody @Valid UserCredentialsDto userCredentialsDto){
        User user = userService.findByUsername(userCredentialsDto.getUsername())
                .orElseThrow(()->new RuntimeException("Invalid login or password"));
        if (user.getPassword().equals(userCredentialsDto.getPassword())) {
            return new UserAuthenticationDto(
                    user.getId(),
                    user.getUsername(),
                    jwtService.createJwtToken(user),
                    "success"
            );
        } else {
            throw  new RuntimeException("Invalid login or password");
        }

    }
}
