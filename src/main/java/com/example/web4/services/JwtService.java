package com.example.web4.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.web4.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;

@Service
@AllArgsConstructor
public class JwtService {
    private static final String SECRET = "AVShtanahTiDvaHeraDerzhish";

    private final Algorithm algorithm = HMAC256(SECRET);
    private final JWTVerifier verifier = JWT.require(algorithm).build();

    public String createJwtToken(User user) {
        try {
            return JWT.create().withClaim("userId", user.getId()).sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("JWT token creation failed due to '" + exception + "'");
        }
    }

    public Long decodeJwtToId(String jwt) {
        try {
            return verifier.verify(jwt).getClaim("userId").asLong();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Provided JWT token is invalid");
        }
    }
}
