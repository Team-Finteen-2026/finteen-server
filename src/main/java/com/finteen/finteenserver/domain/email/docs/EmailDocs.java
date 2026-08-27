package com.finteen.finteenserver.domain.email.docs;

import com.finteen.finteenserver.domain.email.dto.request.EmailSendRequest;
import com.finteen.finteenserver.domain.email.dto.request.EmailVerifyRequest;
import com.finteen.finteenserver.global.common.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Email", description = "이메일 인증")
public interface EmailDocs {
    @Operation(summary = "인증코드 발송", description = "이메일로 인증코드를 발송합니다.")
    Response sendEmail(@RequestBody EmailSendRequest request);

    @Operation(summary = "인증코드 검증", description = "인증코드의 일치 여부를 확인합니다.")
    Response verifyEmail(@RequestBody EmailVerifyRequest request);
}