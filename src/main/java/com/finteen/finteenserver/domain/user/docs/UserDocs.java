package com.finteen.finteenserver.domain.user.docs;

import com.finteen.finteenserver.domain.user.dto.request.UserUpdateRequest;
import com.finteen.finteenserver.domain.user.dto.response.UserResponse;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.common.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "사용자 정보 및 계정 관리")
public interface UserDocs {
    @Operation(
            summary = "내 프로필 조회",
            description = "내 프로필을 조회합니다."
    )
    DataResponse<UserResponse> getMyProfile();

    @Operation(
            summary = "내 프로필 수정",
            description = "내 프로필 정보를 수정합니다."
    )
    DataResponse<UserResponse> updateMyProfile(UserUpdateRequest request);

    @Operation(
            summary = "회원 탈퇴",
            description = "사용자의 계정을 삭제합니다."
    )
    Response deleteUser();
}