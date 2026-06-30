package com.mental.service;

import com.mental.model.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {


    private final String secret =
            "12345678912345678912345678912345";


    public String generate(User user){


        return Jwts.builder()

                .subject(user.getEmail())

                .claim("role",
                        user.getRole().name())

                .issuedAt(new Date())

                .expiration(
                        new Date(System.currentTimeMillis()
                                + 1000*60*15))

                .signWith(
                        Keys.hmacShaKeyFor(
                                secret.getBytes()))

                .compact();

    }



    public String extractEmail(String token){


        return Jwts.parser()

                .verifyWith(
                        Keys.hmacShaKeyFor(secret.getBytes()))

                .build()

                .parseSignedClaims(token)

                .getPayload()

                .getSubject();

    }


}
