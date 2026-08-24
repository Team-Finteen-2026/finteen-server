package com.finteen.finteenserver.domain.email.dto.request;

public record VerificationCodeVerifyRequest(
        String email,
        String VerificationCode
) {
}