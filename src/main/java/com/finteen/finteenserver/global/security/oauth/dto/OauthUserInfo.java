package com.finteen.finteenserver.global.security.oauth.dto;

import com.finteen.finteenserver.domain.user.enums.SocialType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OauthUserInfo {
    private final SocialType socialType;
    private final String socialId;
    private final String name;
    private final String email;
    private final String profileImage;
}