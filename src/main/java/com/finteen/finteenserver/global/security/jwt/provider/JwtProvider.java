package com.finteen.finteenserver.global.security.jwt.provider;

import com.finteen.finteenserver.global.security.jwt.enums.JwtType;
import com.finteen.finteenserver.global.security.jwt.properties.JwtProperties;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.System.currentTimeMillis;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;

    public String generate(Long userId, JwtType jwtType) {
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("type", jwtType.name())
                .issuedAt(new Date(currentTimeMillis()))
                .expiration(new Date(currentTimeMillis() + getTokenExpiration(jwtType)))
                .signWith(jwtProperties.getSecretKey())
                .compact();
    }

    private Long getTokenExpiration(JwtType tokenType) {
        if (tokenType == JwtType.ACCESS) return jwtProperties.getAccessTokenExpiration();
        return jwtProperties.getRefreshTokenExpiration();
    }
}