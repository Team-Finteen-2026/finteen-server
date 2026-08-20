package com.finteen.finteenserver.global.security.jwt.provider;

import com.finteen.finteenserver.global.security.jwt.enums.TokenType;
import com.finteen.finteenserver.global.security.jwt.properties.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;

    public String generate(Long userId, TokenType tokenType) {
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("type", tokenType.name())
                .issuedAt(new Date(currentTimeMillis() + getTokenExpiration(tokenType)))
                .signWith(getSecretKey())
                .compact();
    }

    private Long getTokenExpiration(TokenType tokenType) {
        if (tokenType == TokenType.ACCESS) return jwtProperties.getAccessTokenExpiration();
        return jwtProperties.getRefreshTokenExpiration();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(
                jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8)
        );
    }
}