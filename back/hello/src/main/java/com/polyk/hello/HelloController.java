package com.polyk.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URL;

@RestController("/")
public class HelloController {

    @GetMapping("full-greeting")
    public String getFullGreeting() throws Exception {
        URL url = new URL("http://localhost:8081/greeting-end");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        String end = new String(connection.getInputStream().readAllBytes());

        return "Hello" + " " + end;
    }
}
