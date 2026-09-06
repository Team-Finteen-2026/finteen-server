package com.finteen.finteenserver.global.security.oauth2.dto;

public record OAuth2UserInfo(
        String providerId,
        String email
) {
}