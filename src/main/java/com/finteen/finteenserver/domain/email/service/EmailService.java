package com.finteen.finteenserver.domain.email.service;

import com.finteen.finteenserver.domain.email.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.domain.email.dto.request.VerificationCodeVerifyRequest;
import com.finteen.finteenserver.domain.email.utils.HtmlLoader;
import com.finteen.finteenserver.domain.email.utils.VerificationCodeGenerator;
import com.finteen.finteenserver.global.common.dto.Response;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final RedisTemplate<String, String> redisTemplate;

    public Response sendVerificationCode(VerificationCodeSendRequest request) {
        String verificationCode = VerificationCodeGenerator.generate();

        try {
            String html = HtmlLoader.loadVerificationCodeHtml(
                    verificationCode
            );

            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    true,
                    "UTF-8"
            );

            helper.setTo(request.email());
            helper.setSubject("핀틴 이메일 인증 코드");
            helper.setText(html, true);

            javaMailSender.send(message);
        } catch (MessagingException |IOException e) {
            throw new RuntimeException(e);
        }

        return Response.ok("이메일 인증 코드 발송 성공");
    }

    public Response verifyVerificationCode(VerificationCodeVerifyRequest request) {
        return Response.ok("이메일 인증 완료");
    }
}