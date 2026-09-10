package com.finteen.finteenserver.global.security.oauth2.dto;

import com.finteen.finteenserver.domain.user.entity.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User {
    private final OAuth2User oAuth2User;
    private final UserEntity userEntity;

    @Override
    public String getName() {
        return userEntity.getId().toString();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(
                        "ROLE_" + userEntity.getRole().name()
                )
        );
    }
}