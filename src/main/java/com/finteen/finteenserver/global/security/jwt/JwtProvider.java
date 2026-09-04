package com.finteen.finteenserver.global.security.jwt;

import com.finteen.finteenserver.domain.user.entity.UserEntity;
import com.finteen.finteenserver.domain.user.enums.UserRole;
import com.finteen.finteenserver.global.security.jwt.enums.JwtType;
import com.finteen.finteenserver.global.security.jwt.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.System.currentTimeMillis;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;

    public String generate(
            JwtType jwtType,
            Long userId,
            UserRole userRole
    ) {
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("role", userRole.name())
                .claim("type", jwtType.name())
                .issuedAt(new Date(currentTimeMillis()))
                .expiration(
                        new Date(
                                currentTimeMillis() + getTokenExpiration(jwtType)
                        )
                )
                .signWith(jwtProperties.getSecretKey())
                .compact();
    }

    public Claims parse(String token) {
        return Jwts.parser()
                .verifyWith(jwtProperties.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Long getUserId(String token) {
        return Long.valueOf(parse(token).getSubject());
    }

    public UserRole getUserRole(String token) {
        return UserRole.valueOf(
                parse(token).get("role", String.class)
        );
    }

    private Long getTokenExpiration(JwtType tokenType) {
        if (tokenType == JwtType.ACCESS) {
            return jwtProperties.getAccessTokenExpiration();
        }
        return jwtProperties.getRefreshTokenExpiration();
    }
}