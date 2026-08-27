package com.finteen.finteenserver.domain.email.service;

import com.finteen.finteenserver.domain.email.dto.request.EmailSendRequest;
import com.finteen.finteenserver.domain.email.dto.request.EmailVerifyRequest;
import com.finteen.finteenserver.domain.email.exception.VerificationCodeExpiredException;
import com.finteen.finteenserver.domain.email.exception.VerificationCodeMismatchException;
import com.finteen.finteenserver.domain.email.utils.VerificationCodeGenerator;
import com.finteen.finteenserver.domain.email.utils.ResourceLoader;
import com.finteen.finteenserver.global.common.dto.Response;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final RedisTemplate<String, String> redisTemplate;
    private final JavaMailSender javaMailSender;

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

        redisTemplate.opsForValue().set(
                "email:verification" + request.email(),
                verificationCode,
                Duration.ofMinutes(5)
        );

        return Response.ok("이메일 인증 코드 발송 성공");
    }

    public Response verifyVerificationCode(EmailVerifyRequest request) {
        String key = "email:verification" + request.email();

        String savedVerificationCode = redisTemplate.opsForValue().get(key);

        if (savedVerificationCode == null) {
            throw new VerificationCodeExpiredException();
        }

        if (!savedVerificationCode.equals(request.verificationCode())) {
            throw new VerificationCodeMismatchException();
        }

        redisTemplate.delete(key);

        return Response.ok("이메일 인증 코드 검증 완료");
    }
}