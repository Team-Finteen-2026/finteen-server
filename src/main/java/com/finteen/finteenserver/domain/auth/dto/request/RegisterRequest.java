package com.finteen.finteenserver.domain.auth.dto.request;

import com.finteen.finteenserver.domain.user.enums.GenderType;

import java.time.LocalDate;

public record RegisterRequest(
        String email,
        String password,
        String nickname,
        LocalDate birth,
        GenderType gender
) {
}