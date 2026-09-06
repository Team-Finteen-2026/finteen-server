package com.finteen.finteenserver.domain.user.dto.request;

public record UserUpdateRequest(
        String name,
        String nickname,
        String profileImage
) {
}