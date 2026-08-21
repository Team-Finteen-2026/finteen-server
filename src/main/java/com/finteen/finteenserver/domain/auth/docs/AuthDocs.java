package com.finteen.finteenserver.domain.auth.docs;

import com.finteen.finteenserver.domain.auth.dto.request.LoginRequest;
import com.finteen.finteenserver.domain.auth.dto.response.TokenResponse;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth", description = "사용자 인증 및 인가")
public interface AuthDocs {
    @Operation(summary = "로그인", description = "사용자를 로그인합니다.")
    DataResponse<TokenResponse> login(LoginRequest request);
}