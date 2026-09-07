package com.finteen.finteenserver.global.security.oauth2.enums;

import com.finteen.finteenserver.domain.user.enums.SocialProvider;
import com.finteen.finteenserver.global.security.oauth2.dto.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public enum OAuth2Provider {
    KAKAO(attributes -> {
        Map<String, Object> kakaoAccount =
                (Map<String, Object>) attributes.get("kakao_account");

        return new OAuth2UserInfo(
                SocialProvider.KAKAO,
                kakaoAccount.get("id").toString(),
                kakaoAccount.get("email").toString()
        );
    }),
    GOOGLE(attributes ->
            new OAuth2UserInfo(
                    SocialProvider.GOOGLE,
                    attributes.get("sub").toString(),
                    attributes.get("email").toString()
            )
    ),
    NAVER(attributes -> {
        Map<String, Object> response =
                (Map<String, Object>) attributes.get("response");

        return new OAuth2UserInfo(
                SocialProvider.NAVER,
                response.get("id").toString(),
                response.get("email").toString()
        );
    });

    private final UserInfoExtractor extractorStrategy;

    public OAuth2UserInfo extractUserInfo(
            Map<String, Object> attributes
    ) {
        return extractorStrategy.extract(attributes);
    }

    @FunctionalInterface
    public interface UserInfoExtractor {
        OAuth2UserInfo extract(Map<String, Object> attributes);
    }
}