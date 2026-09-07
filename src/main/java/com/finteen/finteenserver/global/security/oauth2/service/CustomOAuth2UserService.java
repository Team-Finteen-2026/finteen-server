package com.finteen.finteenserver.global.security.oauth2.service;

import com.finteen.finteenserver.global.security.oauth2.dto.OAuth2UserInfo;
import com.finteen.finteenserver.global.security.oauth2.enums.OAuth2Provider;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {


    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) {
        OAuth2User oAuth2User = super.loadUser(request);

        String registrationId =
                request
                        .getClientRegistration()
                        .getRegistrationId();

        OAuth2Provider provider =
                OAuth2Provider.valueOf(
                        registrationId.toUpperCase()
                );

        OAuth2UserInfo userInfo =
                provider.extractUserInfo(
                        oAuth2User.getAttributes()
                );

        return oAuth2User;
    }
}