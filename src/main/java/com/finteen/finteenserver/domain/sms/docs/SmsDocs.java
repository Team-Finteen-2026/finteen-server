package com.finteen.finteenserver.domain.sms.docs;

import com.finteen.finteenserver.domain.sms.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.domain.sms.dto.request.VerificationCodeVerifyRequest;
import com.finteen.finteenserver.global.common.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "SMS", description = "SMS 인증")
public interface SmsDocs {
    @Operation(summary = "인증번호 발송", description = "휴대전화로 인증번호를 발송합니다.")
    Response sendVerificationCode(
            @RequestBody VerificationCodeSendRequest request
    );

    @Operation(summary = "인증번호 검증", description = "입력한 인증번호를 검증합니다.")
    Response verifyVerificationCode(
            @RequestBody VerificationCodeVerifyRequest request
    );
}