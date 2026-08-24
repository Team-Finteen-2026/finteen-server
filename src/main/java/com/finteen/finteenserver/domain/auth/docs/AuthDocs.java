package com.finteen.finteenserver.domain.auth.docs;

import com.finteen.finteenserver.domain.auth.dto.request.LoginRequest;
import com.finteen.finteenserver.domain.auth.dto.request.RefreshRequest;
import com.finteen.finteenserver.domain.auth.dto.request.RegisterRequest;
import com.finteen.finteenserver.domain.auth.dto.response.TokenResponse;
import com.finteen.finteenserver.global.common.dto.DataResponse;
import com.finteen.finteenserver.global.common.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "사용자 인증 및 인가")
public interface AuthDocs {
    @Operation(summary = "로그인", description = "사용자를 로그인합니다.")
    DataResponse<TokenResponse> login(@RequestBody LoginRequest request);

    @Operation(summary = "회원가입", description = "사용자를 회원가입합니다.")
    Response register(@RequestBody RegisterRequest request);

    @Operation(summary = "토큰 재발급", description = "토큰을 재발급합니다.")
    DataResponse<TokenResponse> refresh(@RequestBody RefreshRequest request);
}