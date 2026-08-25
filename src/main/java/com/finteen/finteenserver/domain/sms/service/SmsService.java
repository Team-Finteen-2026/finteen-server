package com.finteen.finteenserver.domain.sms.service;

import com.finteen.finteenserver.domain.sms.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.domain.sms.utils.RandomCodeGenerator;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class SmsService {
    private final RedisTemplate<String, String> redisTemplate;

    public Response sendVerificationCode(
            @RequestBody VerificationCodeSendRequest request
    ) {
        String verificationCode = RandomCodeGenerator.generate();

        String key = "sms:verificationCode:" + request.phone();

        redisTemplate.opsForValue().set(
                key,
                verificationCode,
                Duration.ofMinutes(3)
        );

        return Response.ok("SMS 인증 코드 발송 성공");
    }
}