package com.finteen.finteenserver.domain.oauth.dto;

import com.finteen.finteenserver.domain.user.enums.SocialProviderType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OauthUserInfo {
    private final SocialProviderType socialProviderType;
    private final String socialProviderId;
    private final String email;
    private final String name;
}