package com.finteen.finteenserver.domain.auth.dto.response;

public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}