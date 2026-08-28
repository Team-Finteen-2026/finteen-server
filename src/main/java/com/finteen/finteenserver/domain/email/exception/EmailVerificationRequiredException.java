package com.finteen.finteenserver.domain.email.exception;

import com.finteen.finteenserver.domain.email.exception.enums.EmailErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class EmailVerificationRequiredException extends BaseException {
    public EmailVerificationRequiredException() {
        super(EmailErrorCode.EMAIL_VERIFICATION_REQUIRED);
    }
}