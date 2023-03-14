package com.example.web4.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserAuthenticationDto {
    private long id;
    private String username;
    private String JWT;
    private String message;
}