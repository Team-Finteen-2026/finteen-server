package com.finteen.finteenserver.global.security.jwt;

import org.springframework.stereotype.Component;

@Component
public class TokenExtractor {
    private static final String BEARER_PREFIX = "Bearer ";

    public String extract(String header) {
        if (header == null || !header.startsWith(BEARER_PREFIX)) {
            return null;
        }

        return header.substring(BEARER_PREFIX.length());
    }
}