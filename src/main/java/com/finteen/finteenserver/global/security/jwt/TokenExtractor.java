package com.finteen.finteenserver.global.security.jwt;

public class TokenExtractor {
    private static final String BEARER_PREFIX = "Bearer ";

    public String extract(String header) {
        if (header == null || !header.startsWith(BEARER_PREFIX)) {
            return null;
        }

        return header.substring(BEARER_PREFIX.length());
    }
}