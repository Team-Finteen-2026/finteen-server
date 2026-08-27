package com.finteen.finteenserver.domain.email.exception;

import com.finteen.finteenserver.domain.email.exception.enums.EmailErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class VerificationCodeExpiredException extends BaseException {
    public VerificationCodeExpiredException() {
        super(EmailErrorCode.VERIFICATION_CODE_EXPIRED);
    }
}