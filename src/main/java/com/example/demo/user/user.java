package com.example.demo.user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class user {

    @GetMapping("/helloworld")
    public String hello() {
        return"Hello World!";
    }
}