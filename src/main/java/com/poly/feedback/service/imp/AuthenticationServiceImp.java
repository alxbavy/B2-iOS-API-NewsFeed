package com.poly.feedback.service.imp;

import com.poly.feedback.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationServiceImp implements AuthenticationService {
    public ResponseEntity<String> getToken(String email, String password) {
        return (new RestTemplate()).postForEntity("http://localhost:8080/users/signin?email=" + email + "&password=" + password, (Object)null, String.class, new Object[0]);
    }
}