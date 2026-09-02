package com.finteen.finteenserver.global.security.jwt.utils;

import com.finteen.finteenserver.domain.user.exception.UnauthorizedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationHolder {
    public Long getUserId() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getPrincipal() == null) {
            throw new UnauthorizedException();
        }

        return (Long) authentication.getPrincipal();
    }
}