package com.example.web4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//ssh -p 2222 s336504@helios.se.ifmo.ru -Y -L5432:pg:5432
//wThj+6397
@SpringBootApplication
public class Web4Application {

    public static void main(String[] args) {
        SpringApplication.run(Web4Application.class, args);
    }

}
