package ru.jetlabs.ts.authprovider.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Сервис проверки и генерации JWT токена, пока что, ключ не обновляется
 * без перезапуска экземпляра
 *
 * @author Alex
 */
@Service
public class JwtService {

    private static final String SECRET_KEY = gen();
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;

    private final Key key;

    public JwtService() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private static String gen() {
        byte[] bytes = new byte[32];
        new SecureRandom().nextBytes(bytes);
        return new BigInteger(1, bytes).toString(16);
    }

    public String generateToken(int userId) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public int validateToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.getSubject());
    }
}