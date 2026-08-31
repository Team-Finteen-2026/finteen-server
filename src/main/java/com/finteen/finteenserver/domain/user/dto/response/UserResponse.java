package com.finteen.finteenserver.domain.user.dto.response;

import com.finteen.finteenserver.domain.user.entity.UserEntity;

public record UserResponse(
        Long id,
        String name,
        String email,
        String nickname,
        String profileImage
) {
    public static UserResponse from(UserEntity user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getNickname(),
                user.getProfileImage()
        );
    }
}