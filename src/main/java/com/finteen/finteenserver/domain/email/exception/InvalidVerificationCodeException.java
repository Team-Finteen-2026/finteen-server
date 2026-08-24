package com.finteen.finteenserver.domain.email.exception;

import com.finteen.finteenserver.domain.auth.exception.InvalidPasswordException;
import com.finteen.finteenserver.domain.email.exception.enums.EmailErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class InvalidVerificationCodeException extends BaseException {
    public InvalidVerificationCodeException() {
        super(EmailErrorCode.INVALID_VERIFICATION_CODE);
    }
}