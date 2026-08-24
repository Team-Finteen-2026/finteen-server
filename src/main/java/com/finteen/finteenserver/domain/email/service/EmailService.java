package com.finteen.finteenserver.domain.email.service;

import com.finteen.finteenserver.domain.email.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.domain.email.dto.request.VerificationCodeVerifyRequest;
import com.finteen.finteenserver.domain.email.utils.HtmlLoader;
import com.finteen.finteenserver.global.common.dto.Response;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final RedisTemplate<String, String> redisTemplate;

    public Response sendVerificationCode(VerificationCodeSendRequest request) {
        String verificationCode = generateVerificationCode();

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            String html = HtmlLoader.loadVerificationCodeHtml(
                    verificationCode
            );

            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    true,
                    "UTF-8"
            );

            javaMailSender.send(message);
        } catch (MessagingException |IOException e) {
            throw new RuntimeException(e);
        }

        return Response.ok("인증 코드 발송 성공");
    }

    private String generateVerificationCode() {
        SecureRandom random = new SecureRandom();

        return String.format("%06d", random.nextInt(1_000_000));
    }

    public Response verifyVerificationCode(VerificationCodeVerifyRequest request) {
        return Response.ok("이메일 인증 완료");
    }
}