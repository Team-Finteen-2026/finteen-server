package com.finteen.finteenserver.domain.sms.service;

import com.finteen.finteenserver.domain.sms.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.domain.sms.dto.request.VerificationCodeVerifyRequest;
import com.finteen.finteenserver.global.common.dto.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SmsService {
    public Response sendVerificationCode(
            @RequestBody VerificationCodeSendRequest request
    ) {
        return null;
    }

    public Response verifyVerificationCode(
            @RequestBody VerificationCodeVerifyRequest request
            ) {
        return null;
    }
}