package com.finteen.finteenserver.domain.email.docs;

import com.finteen.finteenserver.domain.email.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.global.common.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Email", description = "이메일 인증")
public interface EmailDocs {
    @Operation(summary = "이메일 인증 코드 발송", description = "이메일 인증 코드를 발송합니다.")
    Response sendVerificationCode(
            @RequestBody VerificationCodeSendRequest request
    );
}