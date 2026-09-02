package com.finteen.finteenserver.domain.user.service;

import com.finteen.finteenserver.domain.user.dto.request.UserUpdateRequest;
import com.finteen.finteenserver.domain.user.dto.response.UserResponse;
import com.finteen.finteenserver.domain.user.repository.UserRepository;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.common.dto.Response;
import com.finteen.finteenserver.global.security.jwt.utils.UserAuthenticationHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserAuthenticationHolder userAuthenticationHolder;

    public DataResponse<UserResponse> getMyProfile() {
        return null;
    }

    public DataResponse<UserResponse> updateMyProfile(
            UserUpdateRequest request
    ) {
        return null;
    }

    public Response deleteUser() {
        Long userId = userAuthenticationHolder.getUserId();
        userRepository.deleteById(userId);

        return Response.ok("회원 탈퇴 성공");
    }
}