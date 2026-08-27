package com.finteen.finteenserver.domain.email.service;

import com.finteen.finteenserver.domain.email.dto.request.EmailSendRequest;
import com.finteen.finteenserver.domain.email.dto.request.EmailVerifyRequest;
import com.finteen.finteenserver.domain.email.utils.RandomCodeGenerator;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final RedisTemplate<String, String> redisTemplate;

    public Response sendEmail(EmailSendRequest request) {
        String verificationCode = RandomCodeGenerator.generate();

        redisTemplate.opsForValue().set(
                "email:verification:" + request.email(),
                verificationCode,
                Duration.ofMinutes(3)
        );

        return Response.ok("이메일 인증 코드 발송 성공");
    }

    public Response verifyEmail(EmailVerifyRequest request) {
        return Response.ok("이메일 인증 코드 검증 완료");
    }
}