package com.finteen.finteenserver.global.security.oauth2.handler;

import com.finteen.finteenserver.global.security.jwt.JwtProvider;
import com.finteen.finteenserver.global.security.oauth2.dto.CustomOAuth2User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        CustomOAuth2User customOAuth2User =
                (CustomOAuth2User) authentication.getPrincipal();
    }
}