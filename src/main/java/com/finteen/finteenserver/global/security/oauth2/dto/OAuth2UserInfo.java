package com.finteen.finteenserver.global.security.oauth2.dto;

import com.finteen.finteenserver.domain.user.enums.SocialProvider;

public record OAuth2UserInfo(
        SocialProvider provider,
        String providerId,
        String email
) {
}