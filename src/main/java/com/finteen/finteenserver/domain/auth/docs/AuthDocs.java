package com.finteen.finteenserver.domain.auth.docs;

import com.finteen.finteenserver.global.common.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth", description = "사용자 인증")
public interface AuthDocs {
    @Operation(summary = "로그아웃", description = "유저를 로그아웃합니다.")
    Response logout();
}