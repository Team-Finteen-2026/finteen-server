package com.finteen.finteenserver.global.security.oauth2.handler;

import com.finteen.finteenserver.domain.user.repository.UserRepository;
import com.finteen.finteenserver.global.security.oauth2.enums.OAuth2Provider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        OAuth2AuthenticationToken oAuth2Token =
                (OAuth2AuthenticationToken) authentication;

        OAuth2User oAuth2User =
                (OAuth2User) oAuth2Token.getPrincipal();

        OAuth2Provider provider =
                OAuth2Provider.valueOf(
                        oAuth2Token
                                .getAuthorizedClientRegistrationId()
                                .toUpperCase()
                );
    }
}