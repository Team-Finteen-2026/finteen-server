package com.finteen.finteenserver.domain.email.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HtmlLoader {
    public static String loadVerificationCodeHtml(
            String verificationCode
    ) throws IOException {
        ClassPathResource resource =
                new ClassPathResource("templates/verification-code.html");

        String html = new String(
                resource.getInputStream().readAllBytes(),
                StandardCharsets.UTF_8
        );

        return html.replace(
                "${verificationCode}",
                verificationCode
        );
    }
}