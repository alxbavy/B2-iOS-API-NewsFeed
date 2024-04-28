package com.poly.feedback.service;

import com.poly.feedback.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    ResponseEntity<String> getToken(String email, String password);

    User getUserByToken(HttpServletRequest httpServletRequest);
}