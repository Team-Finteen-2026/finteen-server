package com.finteen.finteenserver.domain.email.utils;

import java.security.SecureRandom;

public class RandomCodeGenerator {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generate() {
        return String.valueOf(
                RANDOM.nextInt(900000) + 100000
        );
    }
}