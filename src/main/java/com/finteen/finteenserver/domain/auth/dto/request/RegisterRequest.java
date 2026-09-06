package com.finteen.finteenserver.domain.auth.dto.request;

public record RegisterRequest(
        String email,
        String password,
        String nickname
) {
}