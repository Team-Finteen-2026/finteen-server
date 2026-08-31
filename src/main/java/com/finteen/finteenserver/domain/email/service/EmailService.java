package com.finteen.finteenserver.domain.email.service;

import com.finteen.finteenserver.domain.email.dto.request.EmailSendRequest;
import com.finteen.finteenserver.domain.email.dto.request.EmailVerifyRequest;
import com.finteen.finteenserver.domain.email.exception.VerificationCodeExpiredException;
import com.finteen.finteenserver.domain.email.exception.VerificationCodeMismatchException;
import com.finteen.finteenserver.domain.email.utils.VerificationCodeGenerator;
import com.finteen.finteenserver.domain.email.utils.ResourceLoader;
import com.finteen.finteenserver.global.common.dto.Response;
import com.finteen.finteenserver.global.redis.service.RedisService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final RedisService redisService;

    public Response sendVerificationCode(EmailSendRequest request) {
        String verificationCode = VerificationCodeGenerator.generate();

        try {
            String html = ResourceLoader.loadVerificationCodeTemplate(
                    verificationCode
            );

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.email());
            helper.setSubject("핀틴 이메일 인증코드");
            helper.setText(html, true);

            javaMailSender.send(message);

        } catch (MessagingException | IOException e) {
            throw new RuntimeException("이메일 인증코드 전송 실패");
        }

        redisService.set(
                "email:verification:code" + request.email(),
                verificationCode,
                Duration.ofMinutes(5)
        );

        return Response.ok("이메일 인증 코드 발송 성공");
    }

    public Response verifyVerificationCode(EmailVerifyRequest request) {
        String storedVerificationCode = redisService.get(
                "email:verification:code" + request.email()
        );

        if (storedVerificationCode == null) {
            throw new VerificationCodeExpiredException();
        }

        if (!storedVerificationCode.equals(request.verificationCode())) {
            throw new VerificationCodeMismatchException();
        }

        redisService.delete(
                "email:verification:code" + request.email()
        );

        redisService.set(
                "email:verificaton:verified" + request.email(),

        )

        return Response.ok("이메일 인증 코드 검증 완료");
    }
}