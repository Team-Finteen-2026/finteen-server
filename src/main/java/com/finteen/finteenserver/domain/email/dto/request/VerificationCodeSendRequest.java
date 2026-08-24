package com.finteen.finteenserver.domain.email.dto.request;

public record VerificationCodeSendRequest(
        String email
) {
}