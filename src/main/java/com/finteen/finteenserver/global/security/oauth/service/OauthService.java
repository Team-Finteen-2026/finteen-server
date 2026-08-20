package com.finteen.finteenserver.global.security.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OauthService extends DefaultOAuth2UserService {
    public OAuth2User loadUser(
            OAuth2UserRequest request
    ) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(request);

        return oauth2User;
    }
}