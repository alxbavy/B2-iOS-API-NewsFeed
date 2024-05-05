package com.poly.feedback.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
    private String JWT_SECRET = "secret-key";

    @PostConstruct
    protected void init() {
        this.JWT_SECRET = Base64.getEncoder().encodeToString(this.JWT_SECRET.getBytes());
    }

    public String getEmailFromJWT(String token) {
        return ((Claims)Jwts.parser().setSigningKey(this.JWT_SECRET).parseClaimsJws(token).getBody()).getSubject();
    }
}
