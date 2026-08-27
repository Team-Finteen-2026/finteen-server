package com.finteen.finteenserver.domain.email.controller;

import com.finteen.finteenserver.domain.email.docs.EmailDocs;
import com.finteen.finteenserver.domain.email.dto.request.EmailSendRequest;
import com.finteen.finteenserver.domain.email.dto.request.EmailVerifyRequest;
import com.finteen.finteenserver.domain.email.service.EmailService;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController implements EmailDocs {
    private final EmailService emailService;

    @PostMapping("/send")
    public Response sendVerificationCode(@RequestBody EmailSendRequest request) {
        return emailService.sendVerificationCode(request);
    }

    @PostMapping("/verify")
    public Response verifyVerificationCode(@RequestBody EmailVerifyRequest request) {
        return emailService.verifyVerificationCode(request);
    }
}