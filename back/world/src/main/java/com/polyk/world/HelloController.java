package com.polyk.world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloController {

    @GetMapping("greeting-end")
    public String getFullGreeting() {
        return "world";
    }
}
