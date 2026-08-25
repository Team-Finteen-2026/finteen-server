package com.finteen.finteenserver.domain.sms.dto.request;

import jakarta.validation.constraints.NotBlank;

public record VerificationCodeSendRequest(
        @NotBlank
        String phone
) {
}