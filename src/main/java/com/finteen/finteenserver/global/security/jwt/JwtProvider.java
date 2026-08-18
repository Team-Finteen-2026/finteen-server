package com.finteen.finteenserver.global.security.jwt;

import com.finteen.finteenserver.global.security.jwt.enums.TokenType;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;

    public String generate(TokenType tokenType, Long userId) {
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("category", tokenType.name())
                .issuedAt(new Date())
                .compact();
    }
}