package com.finteen.finteenserver.domain.email.exception;

import com.finteen.finteenserver.domain.email.exception.enums.EmailErrorCode;
import com.finteen.finteenserver.global.common.exception.BaseException;

public class VerificationCodeMismatchException extends BaseException {
    public VerificationCodeMismatchException() {
        super(EmailErrorCode.VERIFICATION_CODE_MISMATCH);
    }
}