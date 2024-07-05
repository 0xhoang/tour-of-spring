package com.xhoang.tourofspring.controller;

//import java.util.Base64;

import java.util.concurrent.atomic.AtomicLong;

import com.xhoang.tourofspring.serializers.Greeting;
import com.xhoang.tourofspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/user/info")
    public Greeting userInfo() {
        var user = userService.getUserById(Long.parseLong("1"));
        if (user == null) {
            return new Greeting(
                    0,
                    "User not found"
            );
        }

        return new Greeting(
                user.get().getId(),
                user.get().getUsername()
        );
    }
}