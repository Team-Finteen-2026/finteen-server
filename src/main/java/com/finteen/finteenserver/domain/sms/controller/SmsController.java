package com.finteen.finteenserver.domain.sms.controller;

import com.finteen.finteenserver.domain.sms.docs.SmsDocs;
import com.finteen.finteenserver.domain.sms.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.domain.sms.dto.request.VerificationCodeVerifyRequest;
import com.finteen.finteenserver.domain.sms.service.SmsService;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SmsController implements SmsDocs {
    private final SmsService smsService;

    @PostMapping("/verification-code/send")
    @Override
    public Response sendVerificationCode(
            @RequestBody VerificationCodeSendRequest request
    ) {
        return smsService.sendVerificationCode(request);
    }

    @PostMapping("/verification-code/verify")
    @Override
    public Response verifyVerificationCode(
            @RequestBody VerificationCodeVerifyRequest request
    ) {
        return smsService.verifyVerificationCode(request);
    }
}