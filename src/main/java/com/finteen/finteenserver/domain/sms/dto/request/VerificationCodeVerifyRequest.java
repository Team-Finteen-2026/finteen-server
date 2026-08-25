package com.finteen.finteenserver.domain.sms.dto.request;

import jakarta.validation.constraints.NotBlank;

public record VerificationCodeVerifyRequest(
        @NotBlank
        String phone,
        @NotBlank
        String verificationCode
) {
}