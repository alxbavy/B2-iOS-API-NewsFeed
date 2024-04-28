package com.poly.feedback.service.imp;

import com.poly.feedback.entity.User;
import com.poly.feedback.exception.MessageException;
import com.poly.feedback.service.AuthenticationService;
import com.poly.feedback.utils.UrlUltis;
import com.poly.feedback.utils.UserUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private UserUtils userUtils;

    public ResponseEntity<String> getToken(String email, String password) {
        return (new RestTemplate()).postForEntity("http://localhost:8080/users/signin?email=" + email + "&password=" + password, (Object)null, String.class, new Object[0]);
    }

    @Override
    public User getUserByToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null){
            return null;
        }
        token = token.substring(7);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<User> user = new RestTemplate().exchange(
                UrlUltis.urlAuthen+"/users/me",
                HttpMethod.GET,
                entity,
                User.class
        );

        User result = user.getBody();
        return result;
    }
}