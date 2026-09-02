package com.finteen.finteenserver.domain.user.controller;

import com.finteen.finteenserver.domain.user.docs.UserDocs;
import com.finteen.finteenserver.domain.user.dto.request.UserUpdateRequest;
import com.finteen.finteenserver.domain.user.dto.response.UserResponse;
import com.finteen.finteenserver.domain.user.service.UserService;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController implements UserDocs {
    private final UserService userService;

    @Override
    @GetMapping("/me")
    public DataResponse<UserResponse> getMyProfile() {
        return userService.getMyProfile();
    }

    @Override
    @PatchMapping
    public DataResponse<UserResponse> updateMyProfile(
            UserUpdateRequest request
    ) {
        return null;
    }

    @Override
    @DeleteMapping
    public Response deleteUser() {
        return userService.deleteUser();
    }
}