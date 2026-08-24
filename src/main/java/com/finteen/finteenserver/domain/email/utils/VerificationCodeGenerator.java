package com.finteen.finteenserver.domain.email.utils;

import java.security.SecureRandom;

public class VerificationCodeGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generate() {
        StringBuilder code = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }

        return code.toString();
    }
}