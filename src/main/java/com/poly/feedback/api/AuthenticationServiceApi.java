package com.poly.feedback.api;


import com.poly.feedback.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/authen"})
@CrossOrigin
public class AuthenticationServiceApi {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping({"/public/all"})
    public ResponseEntity<String> all() {
        return this.authenticationService.getToken("hieutran02102804@gmail.com", "12345");
    }

    @PostMapping({"/public/token"})
    public ResponseEntity<?> getByToken(HttpServletRequest request) {
        return new ResponseEntity<>(authenticationService.getUserByToken(request), HttpStatus.OK);
    }
}