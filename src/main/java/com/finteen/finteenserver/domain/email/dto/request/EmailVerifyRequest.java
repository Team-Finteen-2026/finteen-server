package com.finteen.finteenserver.domain.email.dto.request;

import jakarta.validation.constraints.NotBlank;

public record EmailVerifyRequest(
        @NotBlank
        String email,
        @NotBlank
        String verificationCode
) {
}