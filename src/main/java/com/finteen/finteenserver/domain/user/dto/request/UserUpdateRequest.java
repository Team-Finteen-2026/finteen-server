package com.finteen.finteenserver.domain.user.dto.request;

import com.finteen.finteenserver.domain.user.enums.GenderType;

import java.time.LocalDate;

public record UserUpdateRequest(
        String name,
        String nickname,
        GenderType gender,
        LocalDate birth,
        String profileImage
) {
}