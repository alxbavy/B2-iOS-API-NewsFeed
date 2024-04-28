package com.poly.feedback.utils;

import com.poly.feedback.jwt.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUtils {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String getUserWithAuthority(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null){
            return null;
        }
        token = token.substring(7);
        System.out.println(token);
        String email = this.jwtTokenProvider.getEmailFromJWT(token);
        System.out.println("user:L " + email);
        return email;
    }

    public String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null){
            return null;
        }
        token = token.substring(7);
        return token;
    }
}