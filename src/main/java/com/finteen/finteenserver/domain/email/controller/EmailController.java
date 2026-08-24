package com.finteen.finteenserver.domain.email.controller;

import com.finteen.finteenserver.domain.email.docs.EmailDocs;
import com.finteen.finteenserver.domain.email.dto.request.VerificationCodeSendRequest;
import com.finteen.finteenserver.domain.email.service.EmailService;
import com.finteen.finteenserver.global.common.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController implements EmailDocs {
    private final EmailService emailService;

    @Override
    @PostMapping("/verification-code/send")
    public Response sendVerificationCode(
            @RequestBody VerificationCodeSendRequest request
    ) {
        return emailService.sendVerificationCode(request);
    }
}